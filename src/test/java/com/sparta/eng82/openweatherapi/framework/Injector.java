package com.sparta.eng82.openweatherapi.framework;

import com.sparta.eng82.openweatherapi.framework.interfaces.StatusCodeResponse;

public interface Injector {

    <T extends StatusCodeResponse> T injectDTO(String url, Class<T> clazz);
}
