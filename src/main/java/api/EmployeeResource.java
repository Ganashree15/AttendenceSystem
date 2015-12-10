package api;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import api.data.Employee;
import service.EmployeeService;

@Path(value = "employee")
public class EmployeeResource {

	private final EmployeeService employeeService;

	// ** Injecting the reference to the implementation

	@Inject
	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GET
	@Path(value = "{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("id") long id) {
		return employeeService.retrieve(id);
	}

	// ** Method to delete

	@DELETE
	@Path(value = "{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(@PathParam("id") long id) {
		employeeService.delete(id);

		return Response.status(Status.OK).entity("employee has been successfully deleted")
				.type(MediaType.APPLICATION_JSON).build();
	}

	// **Method to update

	@PUT
	@Path(value = "{id}")
	public Response updateEmployee(@PathParam("id") long id, Employee employee) {
		employeeService.update(id, employee);

		return Response.status(Status.OK).entity("employee has been successfully updated")
				.type(MediaType.APPLICATION_JSON).build();
	}

	// **Method to save or create

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveEmployee(Employee employee) {
		employeeService.save(employee);

		return Response.status(Status.OK).entity("employee has been successfully saved")
				.type(MediaType.APPLICATION_JSON).build();
	}

	// ** Method to find All the employees in the list

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public Collection<Employee> findallEmployee() {
		return employeeService.findAll();
		// return
		// Response.status(Status.OK).entity(employeeService.findAll(employee)).type(MediaType.APPLICATION_JSON)
		// .build();
	}

}