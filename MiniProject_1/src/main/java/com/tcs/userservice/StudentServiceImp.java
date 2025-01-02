package com.tcs.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.dto.AddEnqDto;
import com.tcs.dto.DashboardDto;
import com.tcs.dto.LoginDto;
import com.tcs.dto.ViewEnqDto;
import com.tcs.enity.CounsellorEntity;
import com.tcs.enity.StudentEntity;
import com.tcs.repository.CounsellorRepository;
import com.tcs.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private CounsellorRepository counsellorRepo ;

	@Override
	public boolean addEnquiry(AddEnqDto addEnqDto,String user) {
		
		CounsellorEntity c = counsellorRepo.findBycEmail(user);
		
		StudentEntity e = new StudentEntity();
		
		e.setSName(addEnqDto.getSName());
		e.setSPhoneNumber(addEnqDto.getSPhoneNumber());
		e.setSClassMode(addEnqDto.getSClassMode());
		e.setSStatus(addEnqDto.getSStatus());
		e.setSCourseName(addEnqDto.getSCourseName());
		e.setCounsellorEntity(c);
		
		 StudentEntity save = studentRepo.save(e);
		 
		 if(save!=null)
			 
		    return true;
		 else
			 return false;
	}

	@Override
	public ViewEnqDto viewEnq(ViewEnqDto viewEnqDto) {
		
		return null;
	}

	@Override
	public DashboardDto parameters(String user) {
		
		CounsellorEntity c = counsellorRepo.findBycEmail(user);
		
		List<StudentEntity> s = studentRepo.findByCounsellorEntity_cId(c.getCId());
		
		int totalCount = 0;
		int openCount = 0;
		int lostCount=0;
		int enrollCount = 0;
		
		for(StudentEntity s1:s)
		{
			totalCount++;
			
			System.out.println(s1.getSStatus());
			
			if(s1.getSStatus().contentEquals("Open"))
				openCount++;
			
			if(s1.getSStatus().contentEquals("Enrolled"))
				enrollCount++;
			
			if(s1.getSStatus().contentEquals("Lost"))
				lostCount++;
		}
		
		DashboardDto  d = new DashboardDto();
		
		d.setTotalEnq(totalCount);
		d.setOpenEnq(openCount);
		d.setLostEnq(lostCount);
		d.setEnrollEnq(enrollCount);
		
		return d;
	}

}
