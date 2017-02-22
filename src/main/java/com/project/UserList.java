package com.project;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private static final List<User> userList = new ArrayList();

    private UserList() {}


        public static List getInstance() { return userList;}
}
