package test;

import com.project.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<User> userList = new ArrayList();
        userList.add(new User("mike", "smith", "1234", "mike-smith@mail.ru"));
        userList.add(new User("andrey", "brown", "5555", "andrey-brown@mail.ru"));
        userList.add(new User("zack", "harryson", "7573", "zack-harryson@mail.ru"));
        userList.add(new User("belly", "woss", "3321", "belly-woss@mail.ru"));

        EmployeeService employeeService = new EmployeeService();

    }


}
