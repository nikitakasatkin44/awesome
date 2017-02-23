package com.project;

import com.project.jdbc.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;


@WebServlet(
        name = "RegistrationServlet",
        urlPatterns = {"/registration"}
)
public class RegistrationServlet extends HttpServlet {

    final static Logger logger = Logger.getLogger(RegistrationServlet.class);


    UserService userService = new UserService();

    ApplicationContext context =
            new FileSystemXmlApplicationContext("C:/best-projects/awesome/src/main/webapp/WEB-INF/properties.xml");

    UserRepository userRepository =
            (UserRepository)context.getBean("userRepository");


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("doGet request for /registration");
        String action = req.getParameter("searchAction");
        List<User> users = userRepository.getOrderedUsers();
        forwardListUsers(req, resp, users);





    }

    private void forwardListUsers(HttpServletRequest req, HttpServletResponse resp, List userList)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/list-users.jsp");
        req.setAttribute("userList", userList);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        logger.info("doPost request for /registration, action = " + action);
        if (action == null) {action = "add";}
        switch (action) {
            case "add":
                addUser(req, resp);
                break;
            case "edit":
                editUser(req, resp);
                break;
            case "remove":
                removeUser(req, resp);
                break;
        }
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        try {
            userService.addUser(name, surname, password, email);
            List<User> userList = userService.getAllUsers();
            req.setAttribute("idUser", 1);
            String message = "The new user has been successfully created.";
            req.setAttribute("message", message);
            forwardListUsers(req, resp, userList);
        } catch(Exception e) {}
    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String password = req.getParameter("department");
        String email = req.getParameter("email");
        long idUser = Integer.valueOf(req.getParameter("idEmployee"));
        User user = new User(name, surname, password, email, idUser);
        user.setId(idUser);
        boolean success = userService.updateUser(user);
        String message = null;
        if (success) {
            message = "The employee has been successfully updated.";
        }
        List<User> userList = userService.getAllUsers();
        req.setAttribute("idEmployee", idUser);
        req.setAttribute("message", message);
        forwardListUsers(req, resp, userList);
    }

    private void removeUser(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int idUser = Integer.valueOf(req.getParameter("idUser"));
        int confirm = userService.deleteUser(idUser);

        if (confirm == 1){
            String message = "The user has been successfully removed.";
            req.setAttribute("message", message);
        }
        List<User> userList = userService.getAllUsers();
        forwardListUsers(req, resp, userList);
    }


}
