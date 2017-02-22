package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
public class main {
    public static void main(String[] args) throws IOException {
        System.out.println("enter login");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String login = br.readLine();

        System.out.println("enter password");
        String password = br.readLine();

        ApplicationContext context =
                new ClassPathXmlApplicationContext("src/properties.xml");




    }


}
