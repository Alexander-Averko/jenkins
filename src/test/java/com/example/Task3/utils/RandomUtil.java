package com.example.Task3.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomUtil {
    public static String generateRandomString(int length) {
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return generatedString;
    }

    public static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
