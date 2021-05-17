package com.capgemini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.entities.Employee;
import com.capgemini.util.JPAUtil;

public class EmployeeDaoImplV1 implements EmployeeDao{

	@Override
	public boolean createEmployee(Employee employee) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(employee);
		manager.getTransaction().commit();
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		
		EntityManager manager =  JPAUtil.getEntityManager();
		
		//find then update
		Employee oldEmployee = manager.find(Employee.class, employee.getId());
		
		// update
		oldEmployee.setName(employee.getName());
		oldEmployee.setEmail(employee.getEmail());
		oldEmployee.setSalary(employee.getSalary());
		
		manager.getTransaction().begin();
		manager.merge(oldEmployee);
		manager.getTransaction().commit();
		
		return true;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		//find then delete
		Employee oldEmployee = manager.find(Employee.class, employee.getId());
		
		// txn
		manager.getTransaction().begin();
		manager.remove(oldEmployee);
		manager.getTransaction().commit();
		
		return true;
	}

	@Override
	public Employee findById(int id) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		return manager.find(Employee.class, id);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
