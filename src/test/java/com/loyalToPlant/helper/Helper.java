package com.loyalToPlant.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Helper {

    public static final Properties parameters;

    static {

        parameters = new Properties();
        try {
            parameters.load(new FileInputStream(new File("src/test/resource/parameters.properties")));
        } catch (IOException e) {
            throw new RuntimeException(String.format("Failed to load properties: %s", e.getMessage()));
        }
    }
}
