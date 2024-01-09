package com.lgsi.backend.dto;

import com.lgsi.backend.domain.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddUserInfoRequest {
    private String username;

    public UserInfo toEntity(){
        return UserInfo.builder()
                .username(username)
                .build();
    }
}
