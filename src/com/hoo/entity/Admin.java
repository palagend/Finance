package com.hoo.entity;

/**
 * Created by palagend on 2016/11/25.
 */
public class Admin {
    private int id;
    private String name;
    private String password;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
