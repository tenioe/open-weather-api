package com.sparta.eng82.openweatherapi.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionManager {

    private static String apiKey;

    static {
        try (InputStream input = new FileInputStream("src/test/resources/application.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            apiKey = prop.getProperty("api.key");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static EndPoint getConnection(EndPoint endPoint, String... params) {
        return endPoint.buildEndPoint(apiKey, params);
    }
}
