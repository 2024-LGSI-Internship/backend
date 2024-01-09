package com.lgsi.backend.dto;

import com.lgsi.backend.domain.AirconInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddAirconInfoRequest {

    private Float setTemp;
    private String setMode;
    private LocalDate setDate;
    private LocalTime setTime;
    private String setWindstrength;
    private String setWingangle;
    private Float currentTemp;
    private Float currentHumidity;

    public AirconInfo toEntity(){   //생성자를 사용한 객체 생성 (data transfer obj 를 entity로 만들어 줌)
        return AirconInfo.builder()
                .setTemp(setTemp)
                .setMode(setMode)
                .setDate(setDate)
                .setTime(setTime)
                .setWindstrength(setWindstrength)
                .setWingangle(setWingangle)
                .currentTemp(currentTemp)
                .currentHumidity(currentHumidity)
                .build();
    }
}
