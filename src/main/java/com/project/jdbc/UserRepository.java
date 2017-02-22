package com.project.jdbc;

import javax.sql.DataSource;
import java.util.List;
import com.project.User;
import org.springframework.jdbc.core.JdbcTemplate;

import static com.project.jdbc.Application.TABLE_NAME;

public class UserRepository implements UserRepositoryDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void createDB() {
        String SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +"(\n" +
                "  ID   INT NOT NULL AUTO_INCREMENT,\n" +
                "  NAME VARCHAR(60) NOT NULL,\n" +
                "  SURNAME VARCHAR(60) NOT NULL, \n" +
                "  PASSWORD  VARCHAR(60) NOT NULL,\n" +
                "  EMAIL VARCHAR(60) NOT NULL, \n" +
                ");";

        jdbcTemplateObject.update(SQL);

    }

    public void addUser(String name, String surname, String password, String email) {
        User user = new User(name, surname, password, email);

        String SQL = "INSERT INTO " + TABLE_NAME + " (name, surname, password, email) values (?, ?, ?, ?)";

        jdbcTemplateObject.update( SQL, name, surname, password, email);
        System.out.println("Created Record Name = " + name + " salary = " + surname + password + email);

    }



    public User getUser(Integer UserID) {
        String SQL = "select * from " + TABLE_NAME + " where id = ?";

        User user = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{UserID}, new UserMapper());
        return user;
    }

    public List<User> getOrderedUsers() {
        String SQL = "select * from " + TABLE_NAME ;
        List <User> users = jdbcTemplateObject.query(SQL,
                new UserMapper());
        return users;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void delete(Integer userID) {
        String SQL = "delete from users where id = ?";

        jdbcTemplateObject.update(SQL, userID);
        System.out.println("Deleted Record with ID = " + userID);
    }

    public void update(Integer userID, Integer salary) {
        String SQL = "update " + TABLE_NAME + " set salary = ? where id = ?";

        jdbcTemplateObject.update(SQL, salary, userID);
        System.out.println("Updated Record with ID = " + userID);
    }
}
