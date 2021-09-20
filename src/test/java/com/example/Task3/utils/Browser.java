package com.example.Task3.utils;

public class Browser {

    private static String name = BrowserFactory.getDriverName();

    public static void openPage(String url)
    {
        Logger.info(name, "open page: " + url);
        BrowserFactory.getDriver().get(url);
    }

    public static void refresh() {
        Logger.info(name, "refresh");
        BrowserFactory.getDriver().navigate().refresh();
    }

    public static void forward() {
        Logger.info(name, "forward");
        BrowserFactory.getDriver().navigate().forward();
    }
    public static void back() {
        Logger.info(name, "back");
        BrowserFactory.getDriver().navigate().back();
    }

    public static void maximize() {
        BrowserFactory.getDriver().manage().window().maximize();
    }

    public static void quit() {
        Logger.info("Browser quit");
        BrowserFactory.quit();
    }

    public static String getCurrentUrl() {
        return BrowserFactory.getDriver().getCurrentUrl();
    }

    public static void switchToFrame(String s) {
        BrowserFactory.getDriver().switchTo().frame(s);
    }
    public static void switchToDefaultContent() {
        BrowserFactory.getDriver().switchTo().defaultContent();
    }
}
