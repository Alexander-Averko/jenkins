package com.example.Task3.tests;

import com.example.Task3.pages.HoversPage;
import com.example.Task3.utils.Browser;
import com.example.Task3.utils.ConfigManager;
import com.example.Task3.utils.DataProviderManger;
import com.example.Task3.utils.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoversTest extends BaseTest {

    @Test(dataProvider = "getHoversTestData", dataProviderClass = DataProviderManger.class)
    public void testHovers(String userId) {
        //Navigate to URL (host+path)
        Browser.openPage(ConfigManager.getBaseUrl() + ConfigManager.getHoversUrl());
        HoversPage hoversPage = new HoversPage();
        assertTrue(hoversPage.atPage());

        //Move the cursor to user label
        hoversPage.getUserForm(userId).moveCursor();
        assertEquals(hoversPage.getUserForm(userId).getUserName(), "user" + userId, "User name is wrong!");
        assertTrue(hoversPage.getUserForm(userId).viewProfileButtonIsDisplayed());

        //Click user label
        String profileLink = hoversPage.getUserForm(userId).getViewProfileLink();
        hoversPage.getUserForm(userId).clickViewProfileButton();
        assertEquals(profileLink, Browser.getCurrentUrl(), "Current URL doesn't match link!");

        //Back to the previous page
        Browser.back();
        assertTrue(hoversPage.atPage());
    }
}
