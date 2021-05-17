package com.capgemini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.entities.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public boolean createEmployee(Employee employee) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(employee);
		manager.getTransaction().commit();
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		EntityManager manager = factory.createEntityManager();
		
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
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		EntityManager manager = factory.createEntityManager();
		
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

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		EntityManager manager = factory.createEntityManager();
		
		return manager.find(Employee.class, id);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
