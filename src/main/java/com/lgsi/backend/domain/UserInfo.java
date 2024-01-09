package com.lgsi.backend.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
//접근 권한이 public 이면 무분별한 객체 생성, setter를 통한 임의 값 주입이 문제가 됨
//접근 권한이 private 이면 프록시 객체 생성에 문제가 생김
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자를 통해서 값 변경 목적으로 접근하는 메시지들 차단
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키가 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "user_name" , nullable = false)
    private String username;

    @Builder
    public UserInfo(Long id, String username){
        this.id = id;
        this.username = username;
    }

}
