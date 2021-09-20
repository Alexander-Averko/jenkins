package com.example.Task3.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
    private static WebDriver driver = null;
    private static String driverName = null;

    private BrowserFactory() {

    }

    private static void initialize() {
        if (driver == null) {
            setDriverName(ConfigManager.getBrowser());
            switch (ConfigManager.getBrowser()) {
                case "Chrome":
                    driver = getChromeDriver();
                    break;
                case "Firefox":
                    driver = getFirefoxDriver();
                    break;
            }
        }
    }

    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=" + ConfigManager.getLocale());
        return new ChromeDriver(chromeOptions);
    }

    private static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addPreference("intl.accept_languages", ConfigManager.getLocale());
        return new FirefoxDriver(firefoxOptions);
    }

    public static WebDriver getDriver() {
        if (driver == null) initialize();
        return driver;
    }

    public static String getDriverName() {
        if (driver == null) initialize();
        return driverName;
    }

    private static void setDriverName(String name) {
        driverName = name;
    }

    public static void close() {
        if (driver != null) driver.close();
        driver = null;
    }

    public static void quit() {
        if (driver != null) driver.quit();
        driver = null;
    }
}

