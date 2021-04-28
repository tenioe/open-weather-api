package com.sparta.eng82.openweatherapi.framework.interfaces;

public interface DTOChecker {

    default boolean isNull(Object actual) {
        //TODO: Implementation
        return true;
    }

    default boolean isType(Object actual, Class<?> clazz) {
     //TODO: Implementation
     return true;
    }

    default boolean isEqual(Object expected, Object actual) {
        //TODO: Implementation
        return true;
    }
}
