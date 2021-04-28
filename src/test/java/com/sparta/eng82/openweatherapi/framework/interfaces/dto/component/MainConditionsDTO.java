package com.sparta.eng82.openweatherapi.framework.interfaces.dto.component;

import com.sparta.eng82.openweatherapi.framework.interfaces.DTOChecker;

public interface MainConditionsDTO extends DTOChecker {

    Double getActualTemperature();
    Double getFeelsTemperature();
    Double getMinTemperature();
    Double getMaxTemperature();
    Integer getPressure();
    Integer getSeaLevelPressure();
    Integer getGroundLevelPressure();
    Integer getHumidity();

    boolean maxTempGreaterThanMinTemp();
    boolean humidityBetween0and100();
    boolean tempGreaterThanZeroK();
}
