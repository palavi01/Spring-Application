package com.indusnet.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_details")
public class Student implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "student_roll")
	private String studentRoll;

	@OneToOne
	@JoinColumn(name = "login_id")
	private LoginCheck loginCheck;
	
	@OneToMany(mappedBy="student",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<TeacherVsStudent> teacherVsStudents;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentRoll() {
		return studentRoll;
	}

	public void setStudentRoll(String studentRoll) {
		this.studentRoll = studentRoll;
	}

	public LoginCheck getLoginCheck() {
		return loginCheck;
	}

	public void setLoginCheck(LoginCheck loginCheck) {
		this.loginCheck = loginCheck;
	}

	
	public List<TeacherVsStudent> getTeacherVsStudents() {
		return teacherVsStudents;
	}

	public void setTeacherVsStudents(List<TeacherVsStudent> teacherVsStudents) {
		this.teacherVsStudents = teacherVsStudents;
	}

	@Override
	public String toString() {
		return Integer.toString(id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
