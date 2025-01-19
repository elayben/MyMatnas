package com.example.mymatnasbz;
public class User {
    public String id;
    public String userName;
    public String email;
    public String instructor;
    public String password;

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.instructor="false";
    }

    public User(String id, String userName, String email, String instructor, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.instructor = instructor;
        this.password = password;
    }
}