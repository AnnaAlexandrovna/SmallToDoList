package servlets.user;

import service.SmallToDoService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/user/ToDo")
public class SmallToDoListController extends HttpServlet {

    private SmallToDoService toDoService = new SmallToDoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = (String) request.getSession().getAttribute("login");
        request.setAttribute("todoList", toDoService.getUsersToDoList(login));
        request.getRequestDispatcher("/user/ToDo.jsp").forward(request, response);
    }
}



