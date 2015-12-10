package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import api.data.Employee;
import entity.EmployeeEntity;
import persistence.EmployeeDao;

/**
 * One implementation of the interface for Employee Service
 * 
 */
@Singleton
public class EmployeeServiceImpl implements EmployeeService {

	@Inject
	private EmployeeDao employeeDao;

	@Override
	public Employee retrieve(long id) {
		return entityToEmployee(employeeDao.retrieve(id));
	}

	@Override
	public void delete(long id) {
		employeeDao.delete(id);
	}

	@Override
	public void save(Employee employee) {
		employeeDao.save(employeeToEntity(employee));
	}

	@Override
	public void update(long id, Employee employee) {
		employeeDao.delete(id);
	}

	@Override
	public Collection<Employee> findAll() {
		List<Employee> employees = new ArrayList<Employee>();
		for (EmployeeEntity entity : employeeDao.findAll()) {
			employees.add(entityToEmployee(entity));
		}
		return employees;
	}

	// =========== Helpers ================

	/**
	 * mapping from the entity to employee present in jersey
	 * 
	 */
	private Employee entityToEmployee(EmployeeEntity entity) {
		Employee employee = new Employee();

		employee.setId(entity.getId());
		employee.setFirstName(entity.getFirstName());
		employee.setLastName(entity.getLastName());
		employee.setDateofbirth(entity.getDateofbirth());
		employee.setCreateddate(entity.getCreateddate());
		employee.setEmail(entity.getEmail());
		employee.setJobtitle(entity.getJobtitle());
		employee.setUsername(entity.getUsername());
		employee.setPassword(entity.getPassword());
		employee.setGender(entity.getGender());
		return employee;
	}

	/**
	 * mapping from employee to entity in hibernate jpa
	 * 
	 */
	private EmployeeEntity employeeToEntity(Employee employee) {
		EmployeeEntity entity = new EmployeeEntity();

		entity.setId(employee.getId());
		entity.setFirstName(employee.getFirstName());
		entity.setLastName(employee.getLastName());
		entity.setDateofbirth(employee.getDateofbirth());
		entity.setCreateddate(employee.getCreateddate());
		entity.setEmail(employee.getEmail());
		entity.setJobtitle(employee.getJobtitle());
		entity.setUsername(employee.getUsername());
		entity.setPassword(employee.getPassword());
		entity.setGender(employee.getGender());
		return entity;
	}
}