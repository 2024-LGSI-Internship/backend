package com.lgsi.backend.dto;

import com.lgsi.backend.domain.HumidityTemperature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddHumidityTemperatureRequest {
    private double curHumid;
    private double curTemp;

    public HumidityTemperature toEntity(){
        return HumidityTemperature.builder()
                .curHumid(curHumid)
                .curTemp(curTemp)
                .build();
    }
}
