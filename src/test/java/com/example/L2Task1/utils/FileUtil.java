package com.example.L2Task1.utils;

import java.io.File;

public class FileUtil {
    private FileUtil() {
    }

    public static boolean fileExists(String path) {
        File file = new File(path);
        return file.exists();
    }
}
