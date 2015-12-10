package persistence;

import java.sql.Date;
import java.util.Collection;

import entity.EmployeeEntity;

/**
 * An interface that defines what a Employee Data access model looks like in
 * general
 *
 */
public interface EmployeeDao {

	public EmployeeEntity retrieve(long id);

	public void delete(long id);

	public void save(EmployeeEntity employee);

	public Collection<EmployeeEntity> findAll();

	public void update(int id, String FirstName, String LastName, String jobtitle, String username, String email,
			String password, String gender, Date dateofbirth, Date createddate);

	// public EmployeeEntity findByName(String name, String password);
}