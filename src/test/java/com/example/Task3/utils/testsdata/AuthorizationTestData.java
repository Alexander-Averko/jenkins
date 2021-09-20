package com.example.Task3.utils.testsdata;

public class AuthorizationTestData {
    private String login;
    private String password;

    public AuthorizationTestData() {

    }

    public AuthorizationTestData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    public Object[] getData() {
        return new Object[]{login, password};
    }

    @Override
    public String toString() {
        return "AuthorizationTestData{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
