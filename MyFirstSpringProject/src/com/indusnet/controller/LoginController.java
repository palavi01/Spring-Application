package com.indusnet.controller;

import com.indusnet.model.*;
//import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@SessionAttributes({"loginForm"})
public class LoginController 
{
	@RequestMapping(value="/logindummylink",method = RequestMethod.GET)
	public ModelAndView logindummylink()
	{
		System.out.println("Test");
		System.out.println("Dummy Login Controller");
		return new ModelAndView("login","loginForm",new LoginForm());
	}
	

	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String logincheck(@ModelAttribute("loginForm") LoginForm loginForm,Model model)
	{
		System.out.println("Login Check Controller");
		model.addAttribute("username",loginForm.getUsername());
		model.addAttribute("password",loginForm.getPassword());
		System.out.println("User Name = "+loginForm.getUsername());
		System.out.println("Password = "+loginForm.getPassword());
		return "home";
	}
}
