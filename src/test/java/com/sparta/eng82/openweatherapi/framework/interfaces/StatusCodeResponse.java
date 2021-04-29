package com.sparta.eng82.openweatherapi.framework.interfaces;

public interface StatusCodeResponse {

    int getStatusCode();

    default boolean isStatusCode200() {
        return getStatusCode() == 200;
    }
}
