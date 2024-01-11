package com.lgsi.backend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HumidityTemperature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double curHumid;
    private double curTemp;

    @Column(nullable = false)
    private LocalDateTime savedAt;

    @Builder
    public HumidityTemperature(double curHumid, double curTemp){
        this.curHumid = curHumid;
        this.curTemp = curTemp;
        this.savedAt = LocalDateTime.now();
    }

    public String getFormattedSavedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return this.savedAt.format(formatter);
    }
}
