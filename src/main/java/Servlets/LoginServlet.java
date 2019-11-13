package Servlets;

import Model.User;
import Service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "LoginServlet",
        description = "Login user or admin servlet",
        urlPatterns = {"/homepage"}
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("name");
        String password = request.getParameter("password");
        User user = UserService.getUserService().getClientByName(login);

        if (user != null && user.getPassword().equals(password) && user.getRole().equals("admin")) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("admin/users");
        } else if (user != null && user.getPassword().equals(password) && user.getRole().equals("user")) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("user");
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }
}
