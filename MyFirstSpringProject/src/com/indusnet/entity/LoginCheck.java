package com.indusnet.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.indusnet.enumm.Type;

@Entity
@Table(name = "login_check")
public class LoginCheck implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "type")
	private String type;

	@OneToOne(mappedBy = "loginCheck", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Student student;
	
	@OneToOne(mappedBy = "loginCheck", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Teacher teacher;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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
		LoginCheck other = (LoginCheck) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return Integer.toString(id);
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
