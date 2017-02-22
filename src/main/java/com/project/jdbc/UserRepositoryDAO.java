package com.project.jdbc;



import com.project.User;

import javax.sql.DataSource;
import java.util.List;

public interface UserRepositoryDAO {

    void addUser(String name, String surname, String password, String email);

    User getUser(Integer UserID);

    List<User> getOrderedUsers();

    void setDataSource(DataSource dataSource);

    void delete(Integer UserID);

    void update(Integer UserID, Integer salary);






}
