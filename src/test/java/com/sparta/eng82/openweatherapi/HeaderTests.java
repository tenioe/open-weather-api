package com.sparta.eng82.openweatherapi;


import com.sparta.eng82.openweatherapi.framework.ConnectionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeaderTests {


    @Test
    @DisplayName("testName")
    void testName() {
        System.out.println(ConnectionManager.getHeaders().allValues("Access-Control-Allow-Credentials"));
        System.out.println(ConnectionManager.getHeaders().allValues("Access-Control-Allow-Methods"));
        System.out.println(ConnectionManager.getHeaders().allValues("Access-Control-Allow-Origin"));
        System.out.println(ConnectionManager.getHeaders().allValues("Connection"));
        System.out.println(ConnectionManager.getHeaders().allValues("Content-Length"));
        System.out.println(ConnectionManager.getHeaders().allValues("Content-Type"));
        System.out.println(ConnectionManager.getHeaders().allValues("Date"));
        System.out.println(ConnectionManager.getHeaders().allValues("Server"));
        System.out.println(ConnectionManager.getHeaders().allValues("X-Cache-Key"));
    }


}
