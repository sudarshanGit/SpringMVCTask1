package com.risk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.risk.dao.EmployeeDao;
import com.risk.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
    private EmployeeDao dao;
	
	@Override
	public Employee findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		 dao.saveEmployee(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		Employee entity = dao.findById(employee.getId());
		if(entity!=null){
            entity.setName(employee.getName());
            entity.setJoiningDate(employee.getJoiningDate());
            entity.setSalary(employee.getSalary());
            entity.setAadharNo(employee.getAadharNo());
        }
		
	}

	@Override
	public void deleteEmployeeByAdhar(String aadharNo) {
		 dao.deleteEmployeeByAdhar(aadharNo);
		
	}

	@Override
	public List<Employee> findAllEmployees() {
		
		return dao.findAllEmployees();
	}

	@Override
	public Employee findEmployeeByAdhar(String addharNo) {
		return dao.findEmployeeByAdhar(addharNo);
	}

	@Override
	public boolean isEmployeeAdharUnique(Integer id, String aadharNo) {
		Employee employee = findEmployeeByAdhar(aadharNo);
		return ( employee == null || ((id != null) && (employee.getId() == id)));
	}

}
