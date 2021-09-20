package com.example.Task3.tests;

import com.example.Task3.utils.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    protected void setUp() {
        Browser.maximize();
    }

    @AfterMethod
    protected void tearDown() {
        Browser.quit();
    }
}
