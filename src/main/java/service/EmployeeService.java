package service;

import java.util.Collection;

import api.data.Employee;

/**
 * An interface that defines what a Employee Services looks like in general
 *
 */
public interface EmployeeService {

	public Employee retrieve(long id);

	public void delete(long id);

	public void save(Employee employee);

	public Collection<Employee> findAll();

	public void update(long id, Employee employee);

}