package com.example.Task3.tests;

import com.example.Task3.pages.BasicAuthPage;
import com.example.Task3.utils.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AuthorizationTest extends BaseTest {


    @Test(dataProvider = "getAuthorizationTestData", dataProviderClass = DataProviderManger.class)
    private void basicAuthorization(String login, String password) {
        //Navigate to URL and pass basic authorization credentials
        String URL = "http://" + login + ":" + password + "@" + ConfigManager.getBasicAuthorizationUrl();
        Browser.openPage(URL);
        Logger.info("Pass basic authorization credentials");
        BasicAuthPage basicAuthPage = new BasicAuthPage();
        assertTrue(basicAuthPage.congratsTextIsDisplayed(), "Congrats text is not displayed");
    }
}
