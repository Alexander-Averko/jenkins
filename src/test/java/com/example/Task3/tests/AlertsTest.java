package com.example.Task3.tests;

import com.example.Task3.alerts.Alert;
import com.example.Task3.pages.AlertsPage;
import com.example.Task3.utils.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AlertsTest extends BaseTest {

    @Test(dataProvider = "getAlertsTestData", dataProviderClass = DataProviderManger.class)
    public void jsAlertsTest(String jsAlertText, String jsAlertResultText,
                             String jsConfirmText, String jsConfirmResultText,
                             String jsPromptText, String jsPromptResultText, int lengthRandomText) {
        Browser.openPage(ConfigManager.getBaseUrl() + ConfigManager.getAlertsUrl());

        //Navigate to URL
        AlertsPage alertsPage = new AlertsPage();
        assertTrue(alertsPage.atPage(), "This isn't Alerts page!");

        //Click "Click for JS Alert" button
        alertsPage.clickAlertButton();
        Alert jsAlert = new Alert("JS Alert alert");
        jsAlert.waitForPresent();
        assertEquals(jsAlert.getText(), jsAlertText);

        //Click OK button
        jsAlert.accept();
        assertEquals(alertsPage.getResultText(), jsAlertResultText, "Result text is not valid");

        //Click "Click for JS Confirm" button
        alertsPage.clickConfirmButton();
        Alert alertConfirm = new Alert("JS Confirm alert");
        alertConfirm.waitForPresent();
        assertEquals(alertConfirm.getText(), jsConfirmText, "Alert text is not valid");

        //Click OK button
        alertConfirm.accept();
        assertEquals(alertsPage.getResultText(), jsConfirmResultText, "Result text is not valid");

        //Click "Click for JS Prompt" button
        alertsPage.clickPromptButton();
        Alert alertPrompt = new Alert("JS Prompt alert");
        alertPrompt.waitForPresent();
        assertEquals(alertConfirm.getText(), jsPromptText, "Alert text is not valid");

        //Input random text and press OK button
        String randomText = RandomUtil.generateRandomString(lengthRandomText);
        alertPrompt.sendKeys(randomText);
        alertPrompt.accept();
        assertEquals(alertsPage.getResultText(), jsPromptResultText + randomText, "Result text is not valid");
    }


}
