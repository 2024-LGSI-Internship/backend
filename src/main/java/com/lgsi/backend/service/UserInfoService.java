package com.lgsi.backend.service;

import com.lgsi.backend.domain.UserInfo;
import com.lgsi.backend.dto.AddUserInfoRequest;
import com.lgsi.backend.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserInfoService {
    private final UserInfoRepository userinfoRepository;

    public UserInfo save(AddUserInfoRequest request){
        return userinfoRepository.save(request.toEntity());
    }
}
