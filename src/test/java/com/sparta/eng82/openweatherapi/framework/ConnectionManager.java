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
        return endPoint.buildEndPoint(apiKey, params);
    }


    public static HttpHeaders getStatusCode() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(BASEURL + apiKey)).build();
        HttpHeaders statusCode = null;
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            statusCode = httpResponse.headers();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return statusCode;
    }
}
