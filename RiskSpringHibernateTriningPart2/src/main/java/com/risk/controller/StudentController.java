package com.risk.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.risk.model.Student;
import com.risk.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService sudentSrevice;

	@RequestMapping("/index")
	public String setUpForm(Map<String,Object> map) {
		Student student =new Student();
		map.put("student", student);
		
		return "student";
		
	}
	@RequestMapping(value = "/student.do",method = RequestMethod.POST)
	public String doAction(@ModelAttribute Student student,BindingResult result,@RequestParam String action,Map<String,Object> map ) {
		Student studentResult =new Student();
		
		switch (action.toLowerCase()) {
		case "add":
			sudentSrevice.add(student);
			studentResult=student;
			break;
		case "edit":
			sudentSrevice.edit(student);
			studentResult=student;
			break;
		case "delete":
			sudentSrevice.delete(student.getStudentId());
			studentResult=new Student();
			break;
		case "search":
			Student searchStudentResult=sudentSrevice.getStudent(student.getStudentId());
			studentResult=searchStudentResult!=null ? searchStudentResult:new Student();
			break;
		}
		map.put("student", studentResult);
		map.put("studentList", sudentSrevice.getAllStuent());
		
		return "student";
		
	}
}
