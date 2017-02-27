package com.project.jdbc;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.project.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


import static com.project.jdbc.Application.TABLE_NAME;

public class UserRepository implements UserRepositoryDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void createDB() {
        String SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +"(\n" +
                "  ID   INT NOT NULL AUTO_INCREMENT,\n" +
                "  NAME VARCHAR(60) NOT NULL,\n" +
                "  SURNAME VARCHAR(60) NOT NULL, \n" +
                "  PASSWORD  VARCHAR(60) NOT NULL,\n" +
                "  EMAIL VARCHAR(60) NOT NULL, \n" +
                ");";

        jdbcTemplate.update(SQL);

    }

    public void addUser(String name, String surname, String password, String email) {
        User user = new User(name, surname, password, email);
        String SQL = "INSERT INTO " + TABLE_NAME + " (name, surname, password, email) values (?, ?, ?, ?)";

        try {
            int i = jdbcTemplate.update( SQL, name, surname, password, email);
            System.out.println("Account for '" + name + " " + surname + "' has been created. Your password equals: " + password + " , and your email is: " + email);
            if (i > 0) {
                System.out.println("You are successfully registered");
            } else {
                System.out.println("User already exists");
            }
        } catch(DataAccessException e) {
            System.out.println("Duplicate record");
            return;
        }
    }

    public User getUserByID(Integer UserID) {
        String SQL = "select * from " + TABLE_NAME + " where id = ?";

        User user = jdbcTemplate.queryForObject(SQL,
                new Object[]{UserID}, new UserMapper());
        return user;
    }

    public User getUserByLogin(String login) {
        String SQL = "select * from " + TABLE_NAME + " where name = ?";
        User user = new User();
        try {
            user = jdbcTemplate.queryForObject(SQL, new Object[]{login}, new UserMapper());
            System.out.println("User received from DB");
        } catch(Exception e) {
            System.out.println("Specified user doesn't exist");
        }
        return user;


    }


    public boolean isUserExists(String login) {

        String SQL = "select count(*) from " + TABLE_NAME + " where name = ?";
        boolean result = false;

        int count = jdbcTemplate.queryForObject(SQL, new Object[]{login}, Integer.class);

        if (count > 0) {
            result = true;
        }

        return result;
    }

    public boolean isEmailExists(String email) {

        String SQL = "select count(*) from " + TABLE_NAME + " where email = ?";
        boolean result = false;

        int count = jdbcTemplate.queryForObject(SQL, new Object[]{email}, Integer.class);

        if (count > 0) {
            result = true;
        }

        return result;
    }

    public List<User> getUsers() {
        String SQL = "select * from " + TABLE_NAME;
        List<User> users = jdbcTemplate.query(SQL, new UserMapper());

        return users;

    }

    public List<User> getOrderedUsers() {
        String SQL = "select * from " + TABLE_NAME ;
        List <User> users = jdbcTemplate.query(SQL, new UserMapper());
        return users;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int delete(Integer userID) {
        String SQL = "delete from users where id = ?";

        int i = jdbcTemplate.update(SQL, userID);
        System.out.println("Deleted Record with ID = " + userID);
        return i;
    }

    public void update(Integer userID, Integer salary) {
        String SQL = "update " + TABLE_NAME + " set salary = ? where id = ?";

        jdbcTemplate.update(SQL, salary, userID);
        System.out.println("Updated Record with ID = " + userID);
    }


}
