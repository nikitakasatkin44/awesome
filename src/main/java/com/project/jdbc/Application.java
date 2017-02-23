package com.project.jdbc;

import com.project.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

public class Application {

    final public static String TABLE_NAME = "users";

    public static void main(String args[]) {

        ApplicationContext context =
                new FileSystemXmlApplicationContext("C:/best-projects/awesome/src/main/java/com/project/jdbc/properties.xml");

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

        /*System.out.println("-----Listing Record with ID = 2 ------");
        User user = userRepository.getUserByID(2);
        System.out.print("UserID : " + user.getId());
        System.out.print(" , Name : " + user.getName());
        System.out.print(" , surname : " + user.getSurname());
        System.out.print(" , password : " + user.getPassword());
        System.out.println(" , email : " + user.getEmail());*/

        User user1 = userRepository.getUserByLogin("max");

        System.out.println(user1.getName());
        System.out.println(user1.getPassword());
    }


}
