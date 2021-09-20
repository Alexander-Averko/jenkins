package com.example.Task3.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    private static WebDriverWait pageWait = null;
    private static WebDriverWait alertWait = null;

    private Waits() {
    }

    private static void initialize() {
        pageWait = new WebDriverWait(BrowserFactory.getDriver(), ConfigManager.getWaitForPage());
        alertWait = new WebDriverWait(BrowserFactory.getDriver(), ConfigManager.getWaitForAlert());
    }

    public static void waitForPresentPage(By locatorUniqueElement) {
        if (pageWait == null) initialize();
        pageWait.until(ExpectedConditions.visibilityOfElementLocated(locatorUniqueElement));
    }

    public static Alert waitForPresentAlert() {
        if (pageWait == null) initialize();
        return alertWait.until(ExpectedConditions.alertIsPresent());
    }
}
