package com.tcs.userservice;

import com.tcs.dto.AddEnqDto;
import com.tcs.dto.DashboardDto;
import com.tcs.dto.LoginDto;
import com.tcs.dto.ViewEnqDto;

public interface StudentService {
	
	public boolean addEnquiry(AddEnqDto addEnqDto,String user);
	
	public ViewEnqDto viewEnq(ViewEnqDto viewEnqDto);
	
	public DashboardDto parameters(String user);


}
