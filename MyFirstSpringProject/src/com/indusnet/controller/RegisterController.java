package com.indusnet.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.indusnet.business.RegistrationBusiness;
import com.indusnet.entity.LoginCheck;
import com.indusnet.model.RegisterForm;

@Controller
public class RegisterController 
{
	@Autowired
	RegistrationBusiness registrationBusiness;
	
	@RequestMapping(value="/registerdummylink",method = RequestMethod.GET)
	public ModelAndView registerdummylink()
	{
		System.out.println("Dummy Register Controller");
		return new ModelAndView("registration","registerForm",new RegisterForm());
	}
	

	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String registration(@ModelAttribute("registerForm") RegisterForm registerForm,Model model)
	{
		System.out.println("Registration Controller");
		System.out.println("User Type = "+registerForm.getType());
		System.out.println("User Name = "+registerForm.getUsername());
		System.out.println("Password = "+registerForm.getPassword());
		System.out.println("Name = "+registerForm.getName());
		System.out.println("Roll = "+registerForm.getRoll());
		System.out.println("Phone Number = "+registerForm.getPhone_number());
		System.out.println("Teacher Id = "+registerForm.getTeacher_id());
		System.out.println("Student Id = "+registerForm.getStudent_id());
		
		model.addAttribute("username",registerForm.getUsername());
		
		LoginCheck check = registrationBusiness.register(registerForm);
		System.out.println(check.getId());
		
		model.addAttribute("id",check.getId());
		
		return "home";
	}
}
