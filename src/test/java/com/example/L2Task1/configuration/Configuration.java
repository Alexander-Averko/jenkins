package com.example.L2Task1.configuration;

public class Configuration {
    private Configuration() {
    }

    public static String getStartUrl() {
        return Environment.getCurrentEnvironment().getValue("/startUrl").toString();
    }

    public static String getDefaultImagePath() {
        return Environment.getCurrentEnvironment().getValue("/defaultImagePath").toString();
    }
}
