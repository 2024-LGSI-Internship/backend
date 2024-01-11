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

    @Column(name = "userTemp", nullable = false)
    private Float userTemp;

    @Column(name = "userMode", nullable = false)
    private String userMode;

    @Column(name = "userDate", nullable = false)
    private LocalDate userDate;

    @Column(name = "userTime", nullable = false)
    private LocalTime userTime;

    @Column(name = "userWindstrength", nullable = false)
    private String userWindstrength;

    @Column(name = "userWingangle", nullable = false)
    private String userWingangle;


    @Builder
    public AirconInfo(UserInfo userInfo, Float userTemp, String userMode, LocalDate userDate, LocalTime userTime,
                      String userWindstrength, String userWingangle) {
        this.userInfo = userInfo;
        this.userTemp = userTemp;
        this.userMode = userMode;
        this.userDate = userDate;
        this.userTime = userTime;
        this.userWindstrength = userWindstrength;
        this.userWingangle = userWingangle;
    }


}
