package com.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tcs.dto.AddEnqDto;
import com.tcs.dto.DashboardDto;
import com.tcs.dto.LoginDto;
import com.tcs.dto.RegistrationDto;
import com.tcs.userservice.CounsellorService;
import com.tcs.userservice.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class App {
	
	@Autowired
	private CounsellorService counsellorService ;
	
	@Autowired
	private StudentService studentService ;
	
	@GetMapping("/www.ashokit.in")
	public String login(Model model)
	{
		model.addAttribute("msg1", new LoginDto());
		
		return "Login.html";
	}
	
	@PostMapping("/www.ashokit.in")
	public String login(Model model,LoginDto loginDto,HttpSession session)
	{
		Integer login = counsellorService.login(loginDto);
		
		if(login!=0)
		{    
			
			 session.setAttribute("Username", loginDto.getCEmail());
			 
			 String user = (String) session.getAttribute("Username");
			 
			 DashboardDto parameters = studentService.parameters(user);
			 
			 model.addAttribute("parameter", parameters);

	         return "Dashboard.html";

		}
		else
		{
			model.addAttribute("msg2", "Login Failure");
			
			return "Login.html";
		}
	}
	
	@GetMapping("/registration.in")
	public String register(Model model)
	{
		model.addAttribute("msg2", new RegistrationDto());
		
		return "Register.html";
	}
	
	@PostMapping("/registration.in")
	public String register(Model model,RegistrationDto registrationDto)
	{
		boolean register = counsellorService.register(registrationDto);
		
		if(register)
			model.addAttribute("msg3", "Registration Succeess");
		else
			model.addAttribute("msg3", "Registration Failure");
		
		return "Register.html";
	}
	
	
	@GetMapping("/addenq.in")
	public String addEnquiry(HttpSession session,Model model)
	{
		session.getAttribute("Username");
		
		model.addAttribute("msg4", new AddEnqDto());
		
		return"AddEnquiry.html";
	}
	
	@PostMapping("/addenq.in")
	public String addEnquiry(HttpSession session,AddEnqDto addEnqDto,Model model)
	{
		 String user = (String) session.getAttribute("Username");
		 
		 boolean enquiry = studentService.addEnquiry(addEnqDto, user);
		 
		 if(enquiry)
			 
			model.addAttribute("msg5", "Data Saved Successfully");
		 else
			 model.addAttribute("msg5", "Data Not Saved ");
		 
		return"AddEnquiry.html";
	}
	
	@GetMapping("/dashboard.in")
	public String dashBoard(HttpSession session,Model model){
		
		session.getAttribute("Username");
		
		String user = (String) session.getAttribute("Username");
		
		DashboardDto parameters = studentService.parameters(user);
		
		model.addAttribute("parameter", parameters);
		
		return "Dashboard.html";
	}
	
	@GetMapping("/Logout")
	public String logout(HttpSession session)
	{
		 session.invalidate();
		 
		 return "redirect:/www.ashokit.in"; 
		
	}
	
	

}
