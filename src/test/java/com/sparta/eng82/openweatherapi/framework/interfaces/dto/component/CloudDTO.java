package com.sparta.eng82.openweatherapi.framework.interfaces.dto.component;

import com.sparta.eng82.openweatherapi.framework.interfaces.DTOChecker;

public interface CloudDTO extends DTOChecker {

    default Integer getAll() {
        return null;
    }

    default boolean isGreaterThanZero(Integer all) {
        return false;
    }

}
