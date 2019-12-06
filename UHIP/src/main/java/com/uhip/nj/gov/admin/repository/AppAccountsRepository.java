package com.uhip.nj.gov.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uhip.nj.gov.admin.entity.AppAccountsEntity;

public interface AppAccountsRepository extends JpaRepository<AppAccountsEntity, Long>{
   @Query("SELECT COUNT(email) FROM AppAccountsEntity where email=:email")
	public Integer getEmailCount(@Param("email") String email);

}
