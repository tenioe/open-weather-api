package com.sparta.eng82.openweatherapi.framework.interfaces;

import java.util.Objects;

public interface DTOChecker {

    default boolean isNull(Object actual) {
        return Objects.isNull(actual);
    }

    default boolean isType(Object actual, Class<?> clazz) {
        return actual.getClass().equals(clazz);
    }

    default boolean isEqual(Object expected, Object actual) {
        return actual.equals(expected);
    }
}
