package com.lgsi.backend.repository;

import com.lgsi.backend.domain.AirconInfo;
import com.lgsi.backend.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JpaRepo에서 제공되는 여러 메서드를 사용 가능함
public interface AirconInfoRepository extends JpaRepository<AirconInfo, Long> {
    List<AirconInfo> findByUserInfo(UserInfo userInfo);  //특정 사용자의 에어컨 정보 조회

}
