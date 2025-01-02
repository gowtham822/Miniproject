package com.tcs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.enity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
	
	List<StudentEntity> findByCounsellorEntity_cId(Integer cId);

}
