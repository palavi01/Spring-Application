package com.indusnet.converter;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indusnet.dao.RegistrationDao;
import com.indusnet.entity.LoginCheck;
import com.indusnet.entity.Student;
import com.indusnet.entity.Teacher;
import com.indusnet.entity.TeacherVsStudent;
import com.indusnet.model.RegisterForm;

@Component
public class RegistrationConverter implements
		GenericConverter<LoginCheck, RegisterForm> {

	@Autowired
	RegistrationDao registrationDao;

	@Override
	public LoginCheck modelToEntity(RegisterForm m) {

		Student student = new Student();
		LoginCheck loginCheck = new LoginCheck();
		TeacherVsStudent teacherVsStudent = new TeacherVsStudent();

		Teacher teacher;

		if (m.getType().equalsIgnoreCase("Student")) {

			loginCheck.setUsername(m.getUsername());
			loginCheck.setPassword(m.getPassword());
			loginCheck.setType(m.getType());
			student.setStudentName(m.getName());
			student.setStudentRoll(m.getRoll());
			loginCheck.setStudent(student);
			student.setLoginCheck(loginCheck);

			teacher = registrationDao.findById(m.getTeacher_id());
			System.out.println("Teacher id: " + teacher.getId());

			teacherVsStudent.setStudent(student);
			teacherVsStudent.setTeacher(teacher);
			loginCheck.getStudent().setTeacherVsStudents(
					Arrays.asList(teacherVsStudent));

		} else {
			// TO DO CREATE TEACHER
		}

		return loginCheck;
	}

	@Override
	public RegisterForm entityToModel(LoginCheck e) {

		return null;
	}
	
	
	public RegisterForm entityToModel(Student student) {

		RegisterForm registerForm = new RegisterForm();
		registerForm.setName(student.getStudentName());
		registerForm.setUsername(student.getLoginCheck().getPassword());
		
		return registerForm;
	}

}
