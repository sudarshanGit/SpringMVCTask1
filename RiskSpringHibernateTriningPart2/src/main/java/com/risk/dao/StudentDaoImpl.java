package com.risk.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.risk.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Student student) {
		session.getCurrentSession().save(student);
	}

	@Override
	public void edit(Student student) {
		session.getCurrentSession().update(student);
	}

//	@Override
//	public void delete(int studentId) {
//		
//		session.getCurrentSession().delete(studentId);
//		
//	}
//	
	
	@Override
	public void delete(int studentId) {
		Student  StudentAccounts = new Student();
	    // hibernate deletes objects by the primary key
		StudentAccounts.setStudentId(studentId);
		session.getCurrentSession().delete(StudentAccounts);
		
	}
	

	@Override
	public Student getStudent(int studentId) {
		return (Student) session.getCurrentSession().get(Student.class, studentId);
	}

	@Override
	public List<Student> getAllStuent() {
		return session.getCurrentSession().createQuery("from Student").list();
	}

}
