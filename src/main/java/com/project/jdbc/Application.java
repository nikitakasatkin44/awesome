package com.project.jdbc;

import com.project.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Application {

    final public static String TABLE_NAME = "users";

    public static void main(String args[]) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("WEB-INF/properties.xml");

        UserRepository userRepository =
                (UserRepository)context.getBean("userRepository");

        //userRepository.createDB();


        System.out.println("-----Listing Multiple Records-----");
        List<User> users = userRepository.getOrderedUsers();
        for (User user : users) {
            System.out.print("UserID : " + user.getId());
            System.out.print(" , Name : " + user.getName());
            System.out.print(" , surname : " + user.getSurname());
            System.out.print(" , password : " + user.getPassword());
            System.out.println(" , email : " + user.getEmail());
        }

        System.out.println("-----Listing Record with ID = 2 ------");
        User user = userRepository.getUser(2);
        System.out.print("UserID : " + user.getId());
        System.out.print(" , Name : " + user.getName());
        System.out.print(" , surname : " + user.getSurname());
        System.out.print(" , password : " + user.getPassword());
        System.out.println(" , email : " + user.getEmail());
    }
}
