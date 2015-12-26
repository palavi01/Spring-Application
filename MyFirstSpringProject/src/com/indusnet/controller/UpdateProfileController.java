package com.indusnet.controller;

//import javax.servlet.http.HttpSession;

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
import com.indusnet.model.*;

@Controller
@SessionAttributes({ "loginForm" })
public class UpdateProfileController {
	@Autowired
	RegistrationBusiness registrationBusiness;

	LoginCheck loginCheck = new LoginCheck();

	@RequestMapping(value = "/updateprofiledummylink", method = RequestMethod.GET)
	public ModelAndView updateprofiledummylink(
			@ModelAttribute RegisterForm registerForm) {
		System.out.println("Dummy Update Profile Controller");

		registerForm = registrationBusiness.fetch(1);

		System.out.println("UserName = " + registerForm.getUsername());
		return new ModelAndView("updateprofile", "updateProfileForm",
				new UpdateProfileForm());
	}

	@RequestMapping(value = "/updateprofile", method = RequestMethod.POST)
	public String updateprofile(
			@ModelAttribute("forgotPasswordForm") UpdateProfileForm updateProfileForm,
			Model model) {
		System.out.println("Update Profile Controller");
		System.out.println("User Name = " + updateProfileForm.getUsername());
		System.out.println("Password = " + updateProfileForm.getPassword());
		System.out.println("Name = " + updateProfileForm.getName());
		System.out.println("Roll = " + updateProfileForm.getRoll());
		System.out.println("Phone Number = "
				+ updateProfileForm.getPhone_number());
		System.out.println("Teacher Id = " + updateProfileForm.getTeacher_id());
		System.out.println("Student Id = " + updateProfileForm.getStudent_id());
		model.addAttribute("username", updateProfileForm.getUsername());
		return "home";
	}
}
