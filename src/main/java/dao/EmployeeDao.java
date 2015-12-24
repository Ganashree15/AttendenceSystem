package dao;

import org.springframework.security.core.userdetails.UserDetailsService;

import entity.Employee;

public interface EmployeeDao extends Dao<Employee, Long>, UserDetailsService {
	Employee findByName(String name);
}
