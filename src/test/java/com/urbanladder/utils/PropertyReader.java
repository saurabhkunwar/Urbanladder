package com.urbanladder.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static Properties readProperty() {
        Properties prop = new Properties();
        String fileName = "./src/test/resources/config/config.properties"; 

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("ERROR: Properties file not found at " + file.getAbsolutePath());
            return null;
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            prop.load(fis);
        } catch (IOException e) {
            System.out.println("ERROR: Failed to read properties file.");
            e.printStackTrace();
            return null;
        }

       
        System.out.println("Loaded properties:");
        prop.forEach((key, value) -> System.out.println(key + " = " + value));

        return prop;
    }
}
