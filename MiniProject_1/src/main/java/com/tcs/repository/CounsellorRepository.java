package com.tcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.enity.CounsellorEntity;

public interface CounsellorRepository extends JpaRepository<CounsellorEntity , Integer>{
	
	public boolean existsBycEmail(String email);
	
	public CounsellorEntity findBycEmail(String email);
	
	

}
