package com.example.L2Task1.tests;

import aquality.selenium.browser.AqualityServices;
import com.example.L2Task1.configuration.Configuration;
import com.example.L2Task1.forms.pages.RegistrationPage;
import com.example.L2Task1.forms.pages.WelcomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WelcomePage welcomePage;
    protected RegistrationPage registrationPage;

    @BeforeMethod
    protected void setUp() {
        AqualityServices.getBrowser().goTo(Configuration.getStartUrl());
    }

    @AfterMethod
    protected void tearDown() {
        AqualityServices.getBrowser().quit();
    }
}
