package com.indusnet.dao;

import java.util.List;

import javax.persistence.Id;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jdom.adapters.CrimsonDOMAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.indusnet.entity.LoginCheck;
import com.indusnet.entity.Student;
import com.indusnet.entity.Teacher;
import com.indusnet.model.RegisterForm;

@Repository
// Identify DAO Layer
public class RegistrationDao {

	@Autowired
	SessionFactory sessionFactory;

	public LoginCheck insert(LoginCheck loginCheck) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();

		try {

			transaction.begin();
			session.persist(loginCheck);
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}

		return loginCheck;

	}

	public Teacher findById(int id) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();

		Teacher teacher = null;
		try {

			transaction.begin();
			teacher = (Teacher) session.get(Teacher.class, id);
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}

		return teacher;
	}

	public Student insert(Student student) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();

		try {

			transaction.begin();
			session.persist(student);
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}

		return student;

	}

	public Student fetchStudent(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();

		Student student = null;

		try {

			transaction.begin();
			student = (Student) session.get(Student.class, id);// SELECT * FROM
																// TABLE_NAME
																// WHERE ID=2;
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();

		} finally {
			session.close();
			sessionFactory.close();
		}

		return student;
	}
}
