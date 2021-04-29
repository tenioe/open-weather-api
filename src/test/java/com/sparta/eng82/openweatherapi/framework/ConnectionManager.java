package com.sparta.eng82.openweatherapi.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionManager {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String API_KEY_ENDPOINT = "&appid={API key}";

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

    public static String getConnection(EndPoint endPoint, String... params) {
        return BASE_URL + buildConnection(endPoint.getUrl(), params) + apiKeyEndPoint();
    }

    private static String buildConnection(String by, String... params) {
        StringBuilder builder = new StringBuilder(by);
        int openBracket = builder.indexOf("{");
        int closeBracket;
        int paramCount = 0;
        while (openBracket != -1) {
            closeBracket = builder.indexOf("}");
            if (paramCount < params.length) {
                builder.replace(openBracket, closeBracket + 1, params[paramCount]);
            } else {
                builder.delete(openBracket - 1, closeBracket + 1);
            }
            paramCount++;
            openBracket = builder.indexOf("{");
        }
        return builder.toString();
    }

    private static String apiKeyEndPoint() {
        StringBuilder builder = new StringBuilder(API_KEY_ENDPOINT);
        int startIndex = builder.indexOf("{");
        int endIndex = builder.indexOf("}");
        return builder.replace(startIndex, endIndex + 1, apiKey).toString();
    }
}
