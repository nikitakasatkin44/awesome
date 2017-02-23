package com.project;

import com.project.jdbc.UserList;
import com.project.jdbc.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class UserService {

    List<User> userList = UserList.getInstance();

    ApplicationContext context =
            new FileSystemXmlApplicationContext(
                    "C:/best-projects/awesome/src/main/webapp/WEB-INF/properties.xml"
            );

    UserRepository userRepository =
            (UserRepository)context.getBean("userRepository");

    public List<User> getAllUsers() {

        List<User> userList = userRepository.getOrderedUsers();
        return userList;
    }



    public User getUser(long id) throws Exception {
        Optional<User> match
                = userList.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
        if (match.isPresent()) {
            return match.get();
        } else {
            throw new Exception("The User id " + id + " not found");
        }
    }

    public void addUser(String name, String surname, String password, String email) {
        userRepository.addUser(name, surname, password, email);
        return;
    }

    public boolean updateUser(User user) {
        int matchIdx = 0;
        Optional<User> match = userList.stream()
                .filter(c -> c.getId() == user.getId())
                .findFirst();
        if (match.isPresent()) {
            matchIdx = userList.indexOf(match.get());
            userList.set(matchIdx, user);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteUser(long id) {
        Predicate<User> user = e -> e.getId() == id;
        if (userList.removeIf(user)) {
            return true;
        } else {
            return false;
        }
    }

    public User getUser(String login) {
        return userRepository.getUserByLogin(login);
    }

    public List<User> getUsers(String login) {
        return userRepository.getUsers();
    }

    public List<User> filterUsers(String name) {
        List<User> users = userRepository.getUsers();
        Comparator<User> comparator = Comparator.comparing(User::getName)
                .thenComparing(User::getSurname);
        List<User> result = users
                .stream()
                .filter(e -> e.getName().equalsIgnoreCase(name) || e.getSurname().equalsIgnoreCase(name))
                .sorted(comparator)
                .collect(Collectors.toList());

        return result;


    }


}


