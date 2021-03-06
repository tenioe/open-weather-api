package com.sparta.eng82.openweatherapi.framework.interfaces.dto.component;

import com.sparta.eng82.openweatherapi.framework.interfaces.DTOChecker;

public interface PrecipitationDTO extends DTOChecker {

    Float getOneHourMillis();

    Float getThreeHourMillis();

    boolean checkValuesArePositive();

    boolean checkThreeHGreaterThanOneH();
}
