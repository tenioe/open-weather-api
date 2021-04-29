package com.sparta.eng82.openweatherapi.framework.dto.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.CloudDTO;

public class CloudDTOImpl implements CloudDTO {

    @JsonProperty("all")
    private Integer all;

    @JsonProperty("today")
    private Integer today;

    @Override
    @JsonProperty("all")
    public Integer getCloudCoverage() {
        if (all != null) {
            return all;
        } else if (today != null) {
            return today;
        } else {
            return null;
        }
    }

    @Override
    public boolean isBetween0and100() {
        return (getCloudCoverage() >= 0 && getCloudCoverage() <= 100);
    }

}
