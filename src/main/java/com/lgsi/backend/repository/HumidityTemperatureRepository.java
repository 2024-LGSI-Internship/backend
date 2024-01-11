package com.lgsi.backend.repository;

import com.lgsi.backend.domain.HumidityTemperature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumidityTemperatureRepository extends JpaRepository<HumidityTemperature, Long> {
}
