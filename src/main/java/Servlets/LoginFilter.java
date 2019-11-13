package Servlets;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/user")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Boolean userIsLogged = (Boolean) session.getAttribute("userIsLogged");

        if (userIsLogged != null && userIsLogged) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect("homepage");
        }

    }
}
