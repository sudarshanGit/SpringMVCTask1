package com.risk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.risk.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {

	@Override
	public Employee findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		persist(employee);
	}

	@Override
	public void deleteEmployeeByAdhar(String addharNo) {
		Query query = getSession().createSQLQuery("delete from Employee where aadharNo = :aadharNo");
		query.setString("aadharNo", addharNo);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		Criteria criteria = createEntityCriteria();
		return (List<Employee>) criteria.list();
	}

	@Override
	public Employee findEmployeeByAdhar(String addharNo) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("aadharNo", addharNo));
		return (Employee) criteria.uniqueResult();
	}

}
