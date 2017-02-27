package com.project;


import org.apache.log4j.Logger;

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

    final static Logger logger = Logger.getLogger(LoginServlet.class);

    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("doPost request for /login");
        String login = req.getParameter("name");
        String password = req.getParameter("pass");

        try {
            User user = userService.getUser(login);
            System.out.println(user.getPassword());
            System.out.println(password);

            if (user.getPassword().equals(password)) {

                req.setAttribute("message", "Login successful.");
                System.out.println("login successful");

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/success.jsp");
                dispatcher.forward(req, resp);
            } else {

                req.setAttribute("message", "The username and password did not match.");
                System.out.println("login failure");

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/failure.jsp");
                dispatcher.forward(req, resp);
            }





        } catch (Exception e) {
            logger.info("Entered username and password did not match.");
            System.out.println("The specified user does not exist");
            req.setAttribute("message", "Access denied.");

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/failure.jsp");
            dispatcher.forward(req, resp);

        }
    }
}

