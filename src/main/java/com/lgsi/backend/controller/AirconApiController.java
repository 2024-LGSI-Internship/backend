package com.lgsi.backend.controller;

import com.lgsi.backend.domain.AirconInfo;
import com.lgsi.backend.dto.AddAirconInfoRequest;
import com.lgsi.backend.service.AirconInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AirconApiController {

    private final AirconInfoService airconinfoService;

    @PostMapping("/api/adddata")
    public ResponseEntity<AirconInfo> addAirconInfo(@RequestBody AddAirconInfoRequest request){
        AirconInfo savedAirconInfo = airconinfoService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedAirconInfo);
    }
}
