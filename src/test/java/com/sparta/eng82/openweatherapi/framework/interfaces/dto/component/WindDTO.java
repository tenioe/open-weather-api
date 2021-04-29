package com.sparta.eng82.openweatherapi.framework.interfaces.dto.component;

import com.sparta.eng82.openweatherapi.framework.interfaces.DTOChecker;

public interface WindDTO extends DTOChecker {
    Double getSpeed();
    Double getDegree();
    Double getGust();

    Boolean isSpeedBelowZero();
    Boolean isGustBelowZero();
    Boolean isDegreeBelowZero();


    Double getGust();
}
