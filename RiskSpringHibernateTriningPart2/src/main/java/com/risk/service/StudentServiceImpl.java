package com.risk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.dao.StudentDao;
import com.risk.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao; 
	
	@Transactional
	public void add(Student student) {
		studentDao.add(student);
		
	}

	@Transactional
	public void edit(Student student) {
		studentDao.edit(student);
		
	}

	@Transactional
	public void delete(int studentId) {
		studentDao.delete(studentId);
		
	}

	@Transactional
	public Student getStudent(int studentId) {
		return studentDao.getStudent(studentId);
	}

	@Transactional
	public List<Student> getAllStuent() {
		return studentDao.getAllStuent();
	}

}
