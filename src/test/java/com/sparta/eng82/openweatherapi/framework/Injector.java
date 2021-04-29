package com.sparta.eng82.openweatherapi.framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.eng82.openweatherapi.framework.interfaces.StatusCodeResponse;

import java.io.IOException;
import java.net.URL;

public class Injector {

    public static <T extends StatusCodeResponse> T injectDTO(EndPoint endPoint) {
        StatusCodeResponse dto = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            dto = objectMapper.readValue(new URL(endPoint.getUrl()), endPoint.getDTOClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (T) dto;
    }
}
