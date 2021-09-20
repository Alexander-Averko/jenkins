package com.example.Task3.utils;

public class Config {
    private String baseUrl;
    private String basicAuthorizationUrl;
    private String alertsUrl;
    private String sliderUrl;
    private String hoversUrl;
    private String iframeUrl;
    private String browser;
    private String locale;
    private int waitForPage;
    private int waitForAlert;

    public Config() {

    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getBasicAuthorizationUrl() {
        return basicAuthorizationUrl;
    }

    public String getAlertsUrl() {
        return alertsUrl;
    }

    public String getSliderUrl() {
        return sliderUrl;
    }

    public String getHoversUrl() {
        return hoversUrl;
    }

    public String getIframeUrl() {
        return iframeUrl;
    }

    public String getBrowser() {
        return browser;
    }

    public String getLocale() {
        return locale;
    }

    public int getWaitForPage() {
        return waitForPage;
    }

    public int getWaitForAlert() {
        return waitForAlert;
    }
}
