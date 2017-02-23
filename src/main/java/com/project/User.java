package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class User {

    private String name;
    private String surname;
    private String password;
    private String email;
    private long id;
    private static final AtomicLong counter = new AtomicLong(1);

    public User(String name, String surname, String password, String email, long id) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.id = id;
    }

    public User(String name, String surname, String password, String email) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;

        this.id = counter.incrementAndGet();
    }

    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}


