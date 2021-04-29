package com.sparta.eng82.openweatherapi.framework.interfaces.dto.component;

import com.sparta.eng82.openweatherapi.framework.interfaces.DTOChecker;

public interface CoordinatesDTO extends DTOChecker {

    Double getLongitude();

    Double getLatitude();

    boolean isLongitudeBetweenNegative180and180();

    boolean isLatitudeBetweenNegative90and90();
}
