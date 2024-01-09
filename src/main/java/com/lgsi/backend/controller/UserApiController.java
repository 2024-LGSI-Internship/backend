package com.lgsi.backend.controller;

import com.lgsi.backend.domain.UserInfo;
import com.lgsi.backend.dto.AddUserInfoRequest;
import com.lgsi.backend.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserInfoService userinfoService;

    @PostMapping("/api/adduser")
    public ResponseEntity<UserInfo> addUserInfo(@RequestBody AddUserInfoRequest request){
        UserInfo savedUserInfo = userinfoService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserInfo);
    }
}
