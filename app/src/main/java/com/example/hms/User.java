package com.example.hms;

public class User {
    private String fullname;
    private String username;
    private String password;
    private String Gender;
    private String email;

    public User() {
    }

    public User(String fullname, String username, String password, String Gender, String email) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.Gender = Gender;
        this.email = email;
    }


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullname='" + fullname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + Gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
