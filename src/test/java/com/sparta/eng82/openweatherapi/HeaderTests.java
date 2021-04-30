package com.sparta.eng82.openweatherapi;


import com.sparta.eng82.openweatherapi.framework.ConnectionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HeaderTests {


    @Test
    @DisplayName("testName")
    void testName() {
        System.out.println(ConnectionManager.getStatusCode().allValues("Access-Control-Allow-Credentials"));
        System.out.println(ConnectionManager.getStatusCode().allValues("Access-Control-Allow-Methods"));
        System.out.println(ConnectionManager.getStatusCode().allValues("Access-Control-Allow-Origin"));
        System.out.println(ConnectionManager.getStatusCode().allValues("Connection"));
        System.out.println(ConnectionManager.getStatusCode().allValues("Content-Length"));
        System.out.println(ConnectionManager.getStatusCode().allValues("Content-Type"));
        System.out.println(ConnectionManager.getStatusCode().allValues("Date"));
        System.out.println(ConnectionManager.getStatusCode().allValues("Server"));
        System.out.println(ConnectionManager.getStatusCode().allValues("X-Cache-Key"));
    }


}
