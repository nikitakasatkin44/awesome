package com.project.jdbc;

import com.project.User;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static final List<User> userList = new ArrayList();

    private UserList(){
    }

    public static List <User> getInstance(){
        return userList;
    }
}
