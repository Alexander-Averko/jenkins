package com.example.Task3.utils;

import org.slf4j.LoggerFactory;

public class Logger {

    private static org.slf4j.Logger logger = null;

    private Logger() {

    }

    private static void initialize() {
        if (logger == null) {
            logger = LoggerFactory.getLogger("Logger");
        }
    }

    public static String info(String message) {
        if (logger == null) initialize();
        logger.info(message);
        return message;
    }

    public static String info(String name, String message) {
        if (logger == null) initialize();
        logger.info(name + ": " + message);
        return name + ": " + message;
    }

    public static String error(String message) {
        if (logger == null) initialize();
        logger.error(message);
        return message;
    }
    public static String error(String name, String message) {
        if (logger == null) initialize();
        logger.error(name + ": " + message);
        return name + ": " + message;
    }
}


