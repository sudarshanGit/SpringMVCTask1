package com.risk.service;

import java.util.List;

import com.risk.model.Employee;

public interface EmployeeService {

	Employee findById(int id);

	void saveEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployeeByAdhar(String ssn);

	List<Employee> findAllEmployees();

	Employee findEmployeeByAdhar(String addharNo);

	boolean isEmployeeAdharUnique(Integer id, String ssn);
}
