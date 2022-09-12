package com.example.hms;

public class Main {
    public static User loggedin_user;
    public static String username;
    public static String Patient;
    public static String tmp_uname;
    public static String tmp_pass;

    public Main() {
    }

    public Main(User loggedin_user) {
        this.loggedin_user = loggedin_user;
    }

    public User getLoggedin_user() {
        return loggedin_user;
    }

    public void setLoggedin_user(User loggedin_user) {
        this.loggedin_user = loggedin_user;
    }
}
