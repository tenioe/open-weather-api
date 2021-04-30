package com.sparta.eng82.openweatherapi.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConnectionManager {
    private static String BASEURL = "https://api.openweathermap.org/data/2.5/find?lat=5&lon=5&cnt=5&appid=";
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
        return endPoint.buildEndPoint(apiKey, Unit.STANDARD, Language.ENGLISH, params);
    }

    public static EndPoint getConnection(EndPoint endPoint, Unit unit, Language language, String... params) {
        return endPoint.buildEndPoint(apiKey, unit, language, params);
    }

    public static EndPoint getConnection(EndPoint endPoint, Unit unit, String... params) {
        return endPoint.buildEndPoint(apiKey, unit, Language.ENGLISH, params);
    }

    public static EndPoint getConnection(EndPoint endPoint, Language language, String... params) {
        return endPoint.buildEndPoint(apiKey, Unit.STANDARD, language, params);
    }


    public static HttpHeaders getHeaders() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(BASEURL + apiKey)).build();
        HttpHeaders httpHeaders = null;
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            httpHeaders = httpResponse.headers();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return httpHeaders;
    }
}
