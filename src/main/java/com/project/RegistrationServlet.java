package com.project;

import com.project.jdbc.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(
        name = "RegistrationServlet",
        urlPatterns = {"/registration"}
)
public class RegistrationServlet extends HttpServlet {

    UserService userService = new UserService();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("searchAction");
        if (action!=null){
            switch (action) {
                case "searchById":
                    searchUserById(req, resp);
                    break;
                case "searchByName":
                    searchUserByName(req, resp);
                    break;
            }
        }else{
            ApplicationContext context =
                    new FileSystemXmlApplicationContext(
                            "C:/best-projects/awesome/src/main/webapp/WEB-INF/properties.xml"
                    );

            UserRepository userRepository =
                    (UserRepository)context.getBean("userRepository");
            List<User> users = userRepository.getOrderedUsers();
            forwardListUsers(req, resp, users);
        }
    }

    private void searchUserById(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        long idUser = Integer.valueOf(req.getParameter("idUser"));
        User user = null;
        try {
            user = userService.getUser(idUser);
        } catch (Exception ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("user", user);
        req.setAttribute("action", "edit");
        String nextJSP = "/jsp/new-user.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    private void searchUserByName(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("searchName");
        List<User> result = userService.searchUsersByName(name);
        forwardListUsers(req, resp, result);
    }

    private void forwardListUsers(HttpServletRequest req, HttpServletResponse resp, List userList)
            throws ServletException, IOException {
        String nextJSP = "/jsp/list-users.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("userList", userList);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
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

         userService.addUser(name, surname, password, email);

        List<User> userList = userService.getAllUsers();
        req.setAttribute("idUser", 1);
        String message = "The new user has been successfully created.";
        req.setAttribute("message", message);
        forwardListUsers(req, resp, userList);
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
        long idUser = Integer.valueOf(req.getParameter("idEmployee"));
        boolean confirm = userService.deleteUser(idUser);
        if (confirm){
            String message = "The employee has been successfully removed.";
            req.setAttribute("message", message);
        }
        List<User> userList = userService.getAllUsers();
        forwardListUsers(req, resp, userList);
    }
}
