package com.capgemini.dao;

import java.util.List;

import com.capgemini.entities.Employee;

public interface EmployeeDao {
	
	public boolean createEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(Employee employee);
	
	public Employee findById(int id);
	public List<Employee> findAll();
	
}
