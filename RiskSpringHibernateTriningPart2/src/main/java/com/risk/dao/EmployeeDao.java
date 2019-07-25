package com.risk.dao;

import java.util.List;

import com.risk.model.Employee;

public interface EmployeeDao {

	Employee findById(int id);

	void saveEmployee(Employee employee);

	void deleteEmployeeByAdhar(String addharNo);

	List<Employee> findAllEmployees();

	Employee findEmployeeByAdhar(String addharNo);
}
