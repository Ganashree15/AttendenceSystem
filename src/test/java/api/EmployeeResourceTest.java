package api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import api.data.Employee;
import persistence.EmployeeDao;
import persistence.EmployeeDaoImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class EmployeeResourceTest extends JerseyTest {

	/**
	 * This is executed only once, not before each test.
	 * 
	 * This will register the Injectable Provider to the ResourceConfiguration
	 * which will allow for the mock objects and jersey test to be linked.
	 */
	@Override
	protected Application configure() {

		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);

		ResourceConfig config = new ResourceConfig(EmployeeResource.class);
		config.register(new InjectableProvider());
		config.register(JacksonFeature.class);

		return config;
	}

	/**
	 * Invoke the retrieve employee and check the http response is 200.
	 */
	@Test
	public void testEmployeeRetrieveResponse() {

		Response response = target("employee/retrieve/57").register(JacksonFeature.class).request().get();

		Employee employee = response.readEntity(Employee.class);

		assertEquals(200, response.getStatus());
		assertEquals("57", employee.getId().toString());
		assertEquals("NarayanaMurthy", employee.getFirstName());
		assertEquals("Ganashree", employee.getLastName());
		assertEquals("1991-02-15", employee.getDateofbirth());

		assertEquals("Engineer", employee.getJobtitle());
		assertEquals("Gana", employee.getUsername());
		assertEquals("2015-11-09", employee.getCreateddate());
		assertEquals("gana@infinitessoft.com", employee.getEmail());
		assertEquals("gana", employee.getPassword());
		assertEquals("Female", employee.getGender());

	}

	/**
	 * Invoke the delete employee and check the http response is 200.
	 */
	@Test
	public void testEmployeeDeleteResponse() {

		Entity<Long> employeeId = Entity.entity(getMockEmployee().getId(), MediaType.APPLICATION_JSON_TYPE);

		Response response = target("employee/delete").register(JacksonFeature.class).request().post(employeeId);

		assertEquals(200, response.getStatus());
		assertEquals("employee has been successfully deleted", response.readEntity(String.class));
	}

	/**
	 * Invoke the save employee and check the http response is 200.
	 */
	@Test
	public void testEmployeeSaveResponse() {

		Entity<Employee> employee = Entity.entity(getMockEmployee(), MediaType.APPLICATION_JSON_TYPE);

		Response response = target("employee/save").register(JacksonFeature.class).request().post(employee);

		assertEquals(200, response.getStatus());
		assertEquals("employee has been successfully saved", response.readEntity(String.class));
	}

	/**
	 * Invoke the update employee and check the http response is 200.
	 */
	@Test
	public void testEmployeeUpdateResponse() {

		Entity<Employee> employee = Entity.entity(getMockEmployee(), MediaType.APPLICATION_JSON_TYPE);

		Response response = target("employee/update").register(JacksonFeature.class).request().post(employee);

		assertEquals(200, response.getStatus());
		assertEquals("employee has been successfully updated", response.readEntity(String.class));
	}

	/**
	 * Invoke the FindAll employee and check the http response is 200.
	 */
	@Test

	public void testFindAll() {
		Response response = target("employee/findAll").register(JacksonFeature.class).request().get();
		Collection<Employee> employees = response.readEntity(new GenericType<List<Employee>>() {
		});

		assertEquals(200, response.getStatus());
		for (Employee employee : employees) {
			assertNotNull(employee.getId().toString());
			assertNotNull(employee.getFirstName());
			assertNotNull(employee.getLastName());
			assertNotNull(employee.getJobtitle());
			assertNotNull(employee.getUsername());
			assertNotNull(employee.getCreateddate());
			assertNotNull(employee.getEmail());
			assertNotNull(employee.getPassword());
			assertNotNull(employee.getGender());
		}
	}

	/**
	 * Mock object that will be returned
	 * 
	 * @return the employee object
	 */
	private Employee getMockEmployee() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setFirstName("NaryanaMurthy");
		employee.setLastName("Ganashree");
		// employee.setDateofbirth("1991-02-15");
		employee.setJobtitle("Engineer");
		employee.setUsername("Gana");
		// employee.setCreateddate("2015-11-09");
		employee.setEmail("gana@infinitessoft.com");
		employee.setPassword("gana");
		employee.setGender("Female");

		return employee;
	}

	class InjectableProvider extends AbstractBinder {

		@Override
		protected void configure() {
			bind(EmployeeServiceImpl.class).to(EmployeeService.class).in(Singleton.class);
			bind(EmployeeDaoImpl.class).to(EmployeeDao.class).in(Singleton.class);
		}

	}
}
