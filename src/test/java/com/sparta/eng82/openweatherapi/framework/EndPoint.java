package com.sparta.eng82.openweatherapi.framework;

import com.sparta.eng82.openweatherapi.framework.dto.CityDTOImpl;
import com.sparta.eng82.openweatherapi.framework.dto.MultipleCityDTOImpl;
import com.sparta.eng82.openweatherapi.framework.interfaces.StatusCodeResponse;

public enum EndPoint {

    BY_CITY_NAME("weather?q={city name},{state code},{country code}", CityDTOImpl.class),
    BY_CITY_ID("weather?id={city id}", CityDTOImpl.class),
    BY_COORDS("weather?lat={lat}&lon={lon}", CityDTOImpl.class),
    BY_ZIP("weather?zip={zip code},{country code}", CityDTOImpl.class),
    BY_BBOX("box/city?bbox={bbox}", MultipleCityDTOImpl.class),
    BY_CIRCLE("find?lat={lat}&lon={lon}&cnt={cnt}", MultipleCityDTOImpl.class);

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String API_KEY_ENDPOINT = "&appid={API key}";

    private final String urlTemplate;
    private final Class<? extends StatusCodeResponse> clazz;
    private final StringBuilder urlBuilder;

    EndPoint(String url, Class<? extends StatusCodeResponse> clazz) {
        this.urlTemplate = url;
        this.clazz = clazz;
        urlBuilder = new StringBuilder(BASE_URL);
    }

    public String getUrl() {
        String temp = urlBuilder.toString();
        urlBuilder.setLength(0);
        urlBuilder.append(BASE_URL);
        return temp;
    }

    public Class<? extends StatusCodeResponse> getDTOClass() {
        return clazz;
    }

    private void setParams(String... params) {
        urlBuilder.append(urlTemplate);
        int openBracket = urlBuilder.indexOf("{");
        int closeBracket;
        int paramCount = 0;
        while (openBracket != -1) {
            closeBracket = urlBuilder.indexOf("}");
            if (paramCount < params.length) {
                urlBuilder.replace(openBracket, closeBracket + 1, params[paramCount]);
            } else {
                urlBuilder.delete(openBracket - 1, closeBracket + 1);
            }
            paramCount++;
            openBracket = urlBuilder.indexOf("{");
        }
    }

    private void setAPIKey(String apiKey) {
        urlBuilder.append(API_KEY_ENDPOINT);
        int startIndex = urlBuilder.indexOf("{");
        int endIndex = urlBuilder.indexOf("}");
        urlBuilder.replace(startIndex, endIndex + 1, apiKey);
    }

    public EndPoint buildEndPoint(String apiKey, String... params) {
        setParams(params);
        setAPIKey(apiKey);
        return this;
    }
}
