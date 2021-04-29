package com.sparta.eng82.openweatherapi.framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.eng82.openweatherapi.framework.interfaces.StatusCodeResponse;

import java.io.IOException;
import java.net.URL;

public class Injector {

    public static <T extends StatusCodeResponse> T injectDTO(String url, Class<T> clazz) {
        StatusCodeResponse dto = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            dto = objectMapper.readValue(new URL(url), clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (T) dto;
    }
}
