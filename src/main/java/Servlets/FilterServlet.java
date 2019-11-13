package Servlets;


import Model.User;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/admin/*")
public class FilterServlet implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        PrintWriter writer = servletResponse.getWriter();

        if (user == null || user.getRole().equals("user")) {
            writer.println("User can't see admin page");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
