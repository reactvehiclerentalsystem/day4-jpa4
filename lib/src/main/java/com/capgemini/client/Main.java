package com.capgemini.client;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.dao.EmployeeDaoImpl;
import com.capgemini.dao.EmployeeDaoImplV1;
import com.capgemini.entities.Employee;

public class Main {
	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDaoImplV1();
		Employee employee = new Employee();
		employee.setName("Dhawan");
		employee.setEmail("Dhawan@gmail.com");
		employee.setSalary(2058460.0);
		dao.createEmployee(employee);
	}
}
