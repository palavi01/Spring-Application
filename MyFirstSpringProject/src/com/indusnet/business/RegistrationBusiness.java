package com.indusnet.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indusnet.converter.RegistrationConverter;
import com.indusnet.dao.RegistrationDao;
import com.indusnet.entity.LoginCheck;
import com.indusnet.entity.Student;
import com.indusnet.model.RegisterForm;

@Service
@Transactional
public class RegistrationBusiness

{
	@Autowired
	RegistrationConverter registrationConverter;
	@Autowired
	com.indusnet.dao.RegistrationDao registrationDao;

	public LoginCheck register(RegisterForm registerForm) {

		LoginCheck loginCheck = null;
		if (registerForm != null) {

			loginCheck = registrationConverter.modelToEntity(registerForm);

			loginCheck = registrationDao.insert(loginCheck);

		}

		return loginCheck;
	}

	public RegisterForm fetch(int id) {
		System.out.println("Coming1");

		Student student = registrationDao.fetchStudent(id);
		RegisterForm registerForm = registrationConverter
				.entityToModel(student);

		return registerForm;
	}
}
