package com.example.Task3.utils.testsdata;

public class HoversTestData {
    private int userNumber;

    public HoversTestData() {
    }

    public int getUserNumber() {
        return userNumber;
    }

    public Object[] getData() {
        return new Object[] { Integer.toString(userNumber) };
    }
}
