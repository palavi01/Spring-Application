package com.indusnet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.indusnet.model.*;

@Controller
public class ForgotPasswordController 
{
	@RequestMapping(value="/forgotpassworddummylink",method = RequestMethod.GET)
	public ModelAndView forgotpassworddummylink()
	{
		System.out.println("Dummy Forgot Password Controller");
		return new ModelAndView("forgotpassword","forgotPasswordForm",new ForgotPasswordForm());
	}
	

	@RequestMapping(value="/forgotpassword",method = RequestMethod.POST)
	public String forgotpassword(@ModelAttribute("forgotPasswordForm") ForgotPasswordForm forgotPasswordForm,Model model)
	{
		System.out.println("Forgot Password Controller");
		System.out.println("Name = "+forgotPasswordForm.getName());
		System.out.println("User Name = "+forgotPasswordForm.getUsername());
		System.out.println("Roll = "+forgotPasswordForm.getRoll());
		System.out.println("Phone Number = "+forgotPasswordForm.getPhone_number());
		model.addAttribute("username",forgotPasswordForm.getUsername());
		return "home";
	}
}
