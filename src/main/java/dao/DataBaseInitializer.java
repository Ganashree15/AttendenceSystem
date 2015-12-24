package dao;

import java.util.Date;

import org.springframework.security.crypto.password.PasswordEncoder;

import entity.Employee;
import entity.Role;

public class DataBaseInitializer {

	private EmployeeDao employeeDao;
	private RoleDao roleDao;
	private PasswordEncoder passwordEncoder;

	public DataBaseInitializer(EmployeeDao employeeDao, RoleDao roleDao,
			PasswordEncoder passwordEncoder) {
		super();
		this.employeeDao = employeeDao;
		this.roleDao = roleDao;
		this.passwordEncoder = passwordEncoder;
	}

	public void initDataBase() {
		// Employee Employee = new Employee("user",
		// this.passwordEncoder.encode("user"));
		// user.addRole("user");
		// this.userDao.save(user);

		Employee admin = new Employee();
		admin.setDateofbirth(new Date());
		admin.setDateofjoined(new Date());
		admin.setEmail("pohsun@gmail.com");
		admin.setName("pohsun, Huang");
		admin.setPassword(this.passwordEncoder.encode("2ggudoou"));
		admin.setUsername("pohsun");
		Role role = new Role();
		role.setName("admin");
		Role user = new Role();
		user.setName("user");
		role = roleDao.save(role);
		user = roleDao.save(user);
		admin.getRoles().add(role);
		admin.getRoles().add(user);

		this.employeeDao.save(admin);
	}

}
