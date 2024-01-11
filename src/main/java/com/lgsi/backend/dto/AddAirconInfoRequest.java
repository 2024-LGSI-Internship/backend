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

    private Float userTemp;
    private String userMode;
    private LocalDate userDate;
    private LocalTime userTime;
    private String userWindstrength;
    private String userWingangle;


    public AirconInfo toEntity(){   //생성자를 사용한 객체 생성 (data transfer obj 를 entity로 만들어 줌)
        return AirconInfo.builder()
                .userTemp(userTemp)
                .userMode(userMode)
                .userDate(userDate)
                .userTime(userTime)
                .userWindstrength(userWindstrength)
                .userWingangle(userWingangle)
                .build();
    }
}
