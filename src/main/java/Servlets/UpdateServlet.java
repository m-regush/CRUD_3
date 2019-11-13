package Servlets;

import Model.User;
import Service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(
        name = "UpdateServlet",
        description = "Update user servlet",
        urlPatterns = {"/admin/update"}
)

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        User user = null;
        try {
            user = UserService.getUserService().getClientById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("id", user.getId());
        request.setAttribute("name", user.getName());
        request.setAttribute("password", user.getPassword());
        request.setAttribute("role", user.getRole());
        request.setAttribute("job", user.getJob());
        request.setAttribute("salary", user.getSalary());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/update.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String job = request.getParameter("job");
        Long salary = Long.parseLong(request.getParameter("salary"));
        User user = new User(id, name, password, role, job, salary);
        try {
            UserService.getUserService().updateUser(user);
            response.sendRedirect("users");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
