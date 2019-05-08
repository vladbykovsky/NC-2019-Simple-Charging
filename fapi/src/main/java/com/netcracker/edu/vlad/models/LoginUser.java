package com.netcracker.edu.vlad.models;

public class LoginUser {

    private String login;
    private String password;

    public LoginUser() {
    }

    public LoginUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String username) {
        this.login = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
