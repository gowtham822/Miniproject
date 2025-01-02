package com.tcs.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tcs.dto.DashboardDto;
import com.tcs.dto.LoginDto;
import com.tcs.dto.RegistrationDto;
import com.tcs.enity.CounsellorEntity;
import com.tcs.repository.CounsellorRepository;

@Service
public class CounsellorServiceImp implements CounsellorService {
	
	@Autowired
	private CounsellorRepository counsellorRepo;
	
	 @Autowired
	 private PasswordEncoder passwordEncoder;

	@Override
	public Integer login(LoginDto loginDto) {
		
		if(counsellorRepo.existsBycEmail(loginDto.getCEmail()))
			
		{   
			CounsellorEntity e = counsellorRepo.findBycEmail(loginDto.getCEmail());
			
		if(	passwordEncoder.matches(loginDto.getCPassword(), e.getCPassword()))
			
			return e.getCId();
		else
			return 0;
		}
		
		else
			
		     return 0;
	}

	@Override
	public boolean register(RegistrationDto registrationDto) {
		
		String encode = passwordEncoder.encode(registrationDto.getCPassword());
		
		registrationDto.setCPassword(encode);
		
		CounsellorEntity e = new CounsellorEntity();
		
		e.setCName(registrationDto.getCName());
		
		e.setCEmail(registrationDto.getCEmail());
		
		e.setCPassword(encode);
		
		e.setCPhoneNumber(registrationDto.getCPhoneNumber());
		
		CounsellorEntity save = counsellorRepo.save(e);
		
		if(save!=null)
		
		    return true;
		
		else 
			
			return false;
	}

	@Override
	public DashboardDto dashboard(Integer cId) {
		
		return null;
	}

	@Override
	public boolean emailCheck(String cEmail) {
		// TODO Auto-generated method stub
		return false;
	}

}
