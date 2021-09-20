package com.example.L2Task1.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomUtil {
    public static String generateRandomAlphabeticString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String generateRandomCyrillicString(int length) {
        String cyrillicCharacters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        return RandomStringUtils.random(length, cyrillicCharacters);
    }

    public static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static String generateRandomValidPassword() {
        String password = RandomStringUtils.random(1, 65, 90, true, false)
                + RandomStringUtils.random(7, 97, 122, false, false)
                + generateRandomInt(0, 9)
                + generateRandomCyrillicString(1);
        return password;
    }

    public static String generateRandomValidEmail(String password) {
        String ch = String.valueOf(password.charAt(0));
        StringBuilder sb = new StringBuilder(RandomStringUtils.random(5, 65, 90, true, false));
        while (sb.indexOf(ch) > -1) {
            sb.deleteCharAt(sb.indexOf(ch));
        }
        String email = sb + ch;
        return email;
    }

}
