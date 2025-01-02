package com.tcs.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class StudentEntity {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sId ;
	
	private String sName ;
	
	private long sPhoneNumber ;
	
	private String sCourseName ;
	
	private String sClassMode ;
	
	private String sStatus;
	
	@ManyToOne
	@JoinColumn(name = "cId")
	private CounsellorEntity counsellorEntity ;
}
