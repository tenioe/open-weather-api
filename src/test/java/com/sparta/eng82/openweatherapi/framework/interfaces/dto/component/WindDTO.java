package com.sparta.eng82.openweatherapi.framework.interfaces.dto.component;

import com.sparta.eng82.openweatherapi.framework.interfaces.DTOChecker;

public interface WindDTO extends DTOChecker {
    Double getSpeed();

    Double getDegree();

    Double getGust();

    Boolean isSpeedGreaterThanZero();

    Boolean isGustGreaterThanZero();

    Boolean isDegreeBetween0And360();

}
