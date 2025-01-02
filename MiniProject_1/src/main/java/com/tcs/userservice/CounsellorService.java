package com.tcs.userservice;

import com.tcs.dto.DashboardDto;
import com.tcs.dto.LoginDto;
import com.tcs.dto.RegistrationDto;


public interface CounsellorService {
	
	public Integer login(LoginDto loginDto);
	
	public boolean register(RegistrationDto registrationDto);
	
	public DashboardDto dashboard(Integer cId);
	
	public boolean emailCheck(String cEmail);

}
