package config;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import persistence.EmployeeDao;
import persistence.EmployeeDaoImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class ApplicationBinder extends AbstractBinder {

	@Override
	protected void configure() {
		// services
		bind(EmployeeServiceImpl.class).to(EmployeeService.class).in(Singleton.class);

		// dao
		bind(EmployeeDaoImpl.class).to(EmployeeDao.class).in(Singleton.class);
	}
}