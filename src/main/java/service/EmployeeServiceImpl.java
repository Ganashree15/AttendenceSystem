package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import transfer.EmployeeTransfer;
import dao.EmployeeDao;
import entity.Employee;

/**
 * One implementation of the interface for Employee Service
 * 
 */
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public EmployeeTransfer retrieve(long id) {
		return toEmployeeTransfer(employeeDao.find(id));
	}

	@Override
	public void delete(long id) {
		employeeDao.delete(id);
	}

	@Override
	public EmployeeTransfer save(Employee employee) {
		return toEmployeeTransfer(employeeDao.save(employee));
	}

	@Override
	public EmployeeTransfer update(long id, Employee employee) {
		return toEmployeeTransfer(employeeDao.save(employee));
	}

	@Override
	public Collection<EmployeeTransfer> findAll() {
		List<EmployeeTransfer> rets = new ArrayList<EmployeeTransfer>();

		for (Employee employee : employeeDao.findAll()) {
			rets.add(toEmployeeTransfer(employee));
		}
		return rets;
	}

	private EmployeeTransfer toEmployeeTransfer(Employee employee) {
		EmployeeTransfer ret = new EmployeeTransfer();
		ret.setId(employee.getId());
		ret.setName(employee.getUsername());
		ret.setRoles(this.createRoleMap(employee));
		return ret;
	}

	private Map<String, Boolean> createRoleMap(UserDetails userDetails) {
		Map<String, Boolean> roles = new HashMap<String, Boolean>();
		for (GrantedAuthority authority : userDetails.getAuthorities()) {
			roles.put(authority.getAuthority(), Boolean.TRUE);
		}
		return roles;
	}

	@Override
	public EmployeeTransfer findByUsername(String username) {
		return toEmployeeTransfer(employeeDao.findByName(username));
	}
}