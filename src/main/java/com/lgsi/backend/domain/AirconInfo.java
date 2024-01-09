package com.lgsi.backend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AirconInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserInfo userInfo;

    @Column(name = "setTemp", nullable = false)
    private Float setTemp;

    @Column(name = "setMode", nullable = false)
    private String setMode;

    @Column(name = "setDate", nullable = false)
    private LocalDate setDate;

    @Column(name = "setTime", nullable = false)
    private LocalTime setTime;

    @Column(name = "setWindstrength", nullable = false)
    private String setWindstrength;

    @Column(name = "setWingangle", nullable = false)
    private String setWingangle;

    @Column(name = "currentTemp")
    private Float currentTemp;

    @Column(name = "currentHumidity")
    private Float currentHumidity;

    @Builder
    public AirconInfo(UserInfo userInfo, Float setTemp, String setMode, LocalDate setDate, LocalTime setTime,
                      String setWindstrength, String setWingangle, Float currentTemp, Float currentHumidity) {
        this.userInfo = userInfo;
        this.setTemp = setTemp;
        this.setMode = setMode;
        this.setDate = setDate;
        this.setTime = setTime;
        this.setWindstrength = setWindstrength;
        this.setWingangle = setWingangle;
        this.currentTemp = currentTemp;
        this.currentHumidity = currentHumidity;
    }


}
