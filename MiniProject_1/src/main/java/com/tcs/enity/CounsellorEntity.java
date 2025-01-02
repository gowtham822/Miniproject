package com.tcs.enity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class CounsellorEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;
	
	private String cName;
	
	private String cEmail;
	
	private String cPassword;
	
	private long cPhoneNumber;
	
	
	@OneToMany(mappedBy = "counsellorEntity" , cascade = CascadeType.ALL)
	private List<StudentEntity> studentEntity;

}
