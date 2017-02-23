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

        User user = userService.getUser(login);
        System.out.println(user.getPassword());
        System.out.println(password);


        if(1 == 1) {
                String message = "Login successful.";
                req.setAttribute("message", message);

            String nextJSP = "/jsp/success.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(req, resp);
        } else {
            String message = "Access denied.";
            req.setAttribute("message", message);

            String nextJSP = "/jsp/failure.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(req, resp);
            }
        }
    }

