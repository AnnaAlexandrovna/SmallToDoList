package servlets;

import service.LoginService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginController extends HttpServlet {

    private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        boolean success = loginService.doLogin(login, password);
        if (success) {
            request.getSession().setAttribute("login", login);
            request.getSession().setAttribute("logged", true);
            response.sendRedirect("/SmallToDoList_war/user/ToDo");
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
