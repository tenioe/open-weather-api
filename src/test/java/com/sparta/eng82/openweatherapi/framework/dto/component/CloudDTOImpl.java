package com.sparta.eng82.openweatherapi.framework.dto.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.eng82.openweatherapi.framework.interfaces.dto.component.CloudDTO;

public class CloudDTOImpl implements CloudDTO {

    @JsonProperty("all")
    private Integer all;

    public CloudDTOImpl() {

    }

    @Override
    @JsonProperty("all")
    public Integer getAll() {
        return all;
    }

    @Override
    public boolean isBetween0and100() {
        return (all >= 0 && all <= 100);
    }
}
