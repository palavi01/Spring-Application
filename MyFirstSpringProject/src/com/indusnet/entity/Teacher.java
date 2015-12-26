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
@Table(name="teacher_details")
public class Teacher  implements Serializable 
{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "teacher_name")
	private String teacherName;
	
	@Column(name = "teacher_phone")
	private String teacherPhone;
	
	@OneToOne
	@JoinColumn(name = "login_id")
	private LoginCheck loginCheck;
	
	@OneToMany(mappedBy="teacher",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<TeacherVsStudent> teacherVsStudents;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherPhone() {
		return teacherPhone;
	}

	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
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
		Teacher other = (Teacher) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
