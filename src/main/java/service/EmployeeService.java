package service;

import java.util.Collection;

import transfer.EmployeeTransfer;
import entity.Employee;

/**
 * An interface that defines what a Employee Services looks like in general
 *
 */
public interface EmployeeService {

	public EmployeeTransfer retrieve(long id);

	public EmployeeTransfer findByUsername(String username);

	public void delete(long id);

	public EmployeeTransfer save(Employee employee);

	public Collection<EmployeeTransfer> findAll();

	public EmployeeTransfer update(long id, Employee employee);

}