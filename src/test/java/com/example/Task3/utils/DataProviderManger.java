package com.example.Task3.utils;

import com.example.Task3.utils.testsdata.AlertsTestData;
import com.example.Task3.utils.testsdata.AuthorizationTestData;
import com.example.Task3.utils.testsdata.HoversTestData;
import com.example.Task3.utils.testsdata.SliderTestData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class DataProviderManger {

    @DataProvider(name = "getAuthorizationTestData")
    public static Object[][] getAuthorizationTestData() {
        return getAuthorizationData();
    }

    @DataProvider(name = "getAlertsTestData")
    public static Object[][] getAlertsTestData() {
        return getAlertData();
    }

    @DataProvider(name = "getSliderTestData")
    public static Object[][] getSliderTestData() {
        return getSliderData();
    }

    @DataProvider(name = "getHoversTestData")
    public static Object[][] getHoversTestData() {
        return getHoversData();
    }

    private static List<JsonNode> readDataFromFile(String testName, ObjectMapper mapper) {
        List<JsonNode> parser = null;

        try {
            parser = mapper.readTree(Paths.get("src/test/resources/testData.json").toFile()).findValues(testName);
        } catch (IOException e) {
            Logger.error("Cannot found Test Data file!");
            e.printStackTrace();
        }
        return parser;
    }

    private static Object[][] getAuthorizationData() {
        ObjectMapper mapper = new ObjectMapper();
        List<JsonNode> parser = readDataFromFile("authorizationTest", mapper);
        List<AuthorizationTestData> testData = null;
        testData = mapper.convertValue(parser.get(0), new TypeReference<List<AuthorizationTestData>>() {
        });
        Object[][] returnValue = new Object[testData.size()][testData.get(0).getData().length];

        for (int i = 0; i < testData.size(); i++) {
            for (int j = 0; j < testData.get(0).getData().length; j++) {
                returnValue[i][j] = testData.get(0).getData()[j];
            }
        }
        return returnValue;
    }

    private static Object[][] getAlertData() {
        ObjectMapper mapper = new ObjectMapper();
        List<JsonNode> parser = readDataFromFile("alertsTest", mapper);
        List<AlertsTestData> testData = null;
        testData = mapper.convertValue(parser.get(0), new TypeReference<List<AlertsTestData>>() {
        });
        Object[][] returnValue = new Object[testData.size()][testData.get(0).getData().length];

        for (int i = 0; i < testData.size(); i++) {
            for (int j = 0; j < testData.get(0).getData().length; j++) {
                returnValue[i][j] = testData.get(0).getData()[j];
            }
        }
        return returnValue;
    }

    private static Object[][] getSliderData() {
        ObjectMapper mapper = new ObjectMapper();
        List<JsonNode> parser = readDataFromFile("sliderTest", mapper);
        List<SliderTestData> testData = null;
        testData = mapper.convertValue(parser.get(0), new TypeReference<List<SliderTestData>>() {
        });
        Object[][] returnValue = new Object[testData.size()][testData.get(0).getData().length];

        for (int i = 0; i < testData.size(); i++) {
            for (int j = 0; j < testData.get(0).getData().length; j++) {
                returnValue[i][j] = testData.get(0).getData()[j];
            }
        }
        return returnValue;
    }

    private static Object[][] getHoversData() {
        ObjectMapper mapper = new ObjectMapper();
        List<JsonNode> parser = readDataFromFile("hoversTest", mapper);
        List<HoversTestData> testData = null;
        testData = mapper.convertValue(parser.get(0), new TypeReference<List<HoversTestData>>() {
        });
        Object[][] returnValue = new Object[testData.size()][testData.get(0).getData().length];

        for (int i = 0; i < testData.size(); i++) {
            for (int j = 0; j < testData.get(0).getData().length; j++) {
                returnValue[i][j] = testData.get(0).getData()[j];
            }
        }
        return returnValue;
    }


}
