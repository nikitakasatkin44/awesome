package com.project;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "LoginServlet",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("name");
        String password = req.getParameter("pass");

        try {
            User user = userService.getUser(login);
            System.out.println(user.getPassword());
            System.out.println(password);

            req.setAttribute("message", "Login successful.");

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/success.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            System.out.println("The specified user does not exist");
            req.setAttribute("message", "Access denied.");

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/failure.jsp");
            dispatcher.forward(req, resp);

        }
    }
}

