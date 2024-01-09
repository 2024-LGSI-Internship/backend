package com.lgsi.backend.service;

import com.lgsi.backend.domain.AirconInfo;
import com.lgsi.backend.dto.AddAirconInfoRequest;
import com.lgsi.backend.repository.AirconInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AirconInfoService {

    private final AirconInfoRepository airconinfoRepository;

    //에어컨 정보 추가 메서드
    public AirconInfo save(AddAirconInfoRequest request){
        return airconinfoRepository.save(request.toEntity());
    }
}
