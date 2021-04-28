package com.sparta.eng82.openweatherapi.framework.interfaces;

public interface DTOChecker {

    boolean isNull(Object actual);
    boolean isType(Object actual, Class<?> clazz);
    boolean isEqual(Object expected, Object actual);
}
