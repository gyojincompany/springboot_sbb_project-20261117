package com.gyojincompany.sbb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyojincompany.sbb.entity.SiteUser;

public interface UserRepository extends JpaRepository<SiteUser, Long>{

}
