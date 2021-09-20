package com.example.L2Task1.utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestDataProvider {
    private static ISettingsFile getTestDataFile() {
        Path resourcePath = Paths.get("testdata", "testdata.json");
        return new JsonSettingsFile(resourcePath.toString());
    }

    public static int getInterestsCount() {
        return Integer.parseInt(getTestDataFile().getValue("/interestsCount").toString());
    }
}
