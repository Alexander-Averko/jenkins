package com.example.Task3.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;


public class ConfigManager {
    private static Config config = null;

    private ConfigManager() {

    }

    private static void initialize() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            config = mapper.readValue(Paths.get("src/test/resources/config.json").toFile(), Config.class);
        } catch (Exception ex) {
            Logger.error("Cannot found Config file!");
            ex.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        if (config == null) initialize();
        return config.getBaseUrl();
    }

    public static String getBasicAuthorizationUrl() {
        if (config == null) initialize();
        return config.getBasicAuthorizationUrl();
    }

    public static String getAlertsUrl() {
        if (config == null) initialize();
        return config.getAlertsUrl();
    }

    public static String getSliderUrl() {
        if (config == null) initialize();
        return config.getSliderUrl();
    }

    public static String getHoversUrl() {
        if (config == null) initialize();
        return config.getHoversUrl();
    }

    public static String getIFrameUrl() {
        if (config == null) initialize();
        return config.getIframeUrl();
    }

    public static String getBrowser() {
        if (config == null) initialize();
        return config.getBrowser();
    }

    public static String getLocale() {
        if (config == null) initialize();
        return config.getLocale();
    }

    public static int getWaitForPage() {
        return config.getWaitForPage();
    }

    public static int getWaitForAlert() {
        return config.getWaitForAlert();
    }

}
