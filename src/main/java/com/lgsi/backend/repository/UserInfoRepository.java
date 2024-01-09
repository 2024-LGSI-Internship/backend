package com.lgsi.backend.repository;

import com.lgsi.backend.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

}
