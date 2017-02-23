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
        name = "ContactServlet",
        urlPatterns = {"/contact"}
)
public class ContactServlet extends HttpServlet {

    final static Logger logger = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("doGet request for /contact");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/contact.jsp");
        dispatcher.forward(req, resp);
    }
}
