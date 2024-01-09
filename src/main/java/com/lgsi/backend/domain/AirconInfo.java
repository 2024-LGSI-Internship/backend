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

    @Column(name = "set_temp", nullable = false)
    private Float set_temp;

    @Column(name = "set_mode", nullable = false)
    private String set_mode;

    @Column(name = "set_date", nullable = false)
    private LocalDate set_date;

    @Column(name = "set_time", nullable = false)
    private LocalTime set_time;

    @Column(name = "set_windstrength", nullable = false)
    private String set_windstrength;

    @Column(name = "set_wingangle", nullable = false)
    private String set_wingangle;

    @Column(name = "current_temp")
    private String current_temp;

    @Column(name = "current_humidity")
    private String current_humidity;

    @Builder
    public AirconInfo(UserInfo userInfo, Float set_temp, String set_mode, LocalDate set_date, LocalTime set_time,
                      String set_windstrength, String set_wingangle, String current_temp, String current_humidity) {
        this.userInfo = userInfo;
        this.set_temp = set_temp;
        this.set_mode = set_mode;
        this.set_date = set_date;
        this.set_time = set_time;
        this.set_windstrength = set_windstrength;
        this.set_wingangle = set_wingangle;
        this.current_temp = current_temp;
        this.current_humidity = current_humidity;
    }


    public void update(Float set_temp, String set_mode, LocalDate set_date, LocalTime set_time,
                       String set_windstrength, String set_wingangle, String current_temp, String current_humidity) {
        this.set_temp = set_temp;
        this.set_mode = set_mode;
        this.set_date = set_date;
        this.set_time = set_time;
        this.set_windstrength = set_windstrength;
        this.set_wingangle = set_wingangle;
        this.current_temp = current_temp;
        this.current_humidity = current_humidity;
    }


}
