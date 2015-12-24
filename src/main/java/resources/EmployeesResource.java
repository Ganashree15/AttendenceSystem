package resources;

import java.util.Collection;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;

import service.EmployeeService;
import transfer.EmployeeTransfer;
import entity.Employee;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/employee")
public class EmployeesResource {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authManager;

	@GET
	@Path(value = "{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeeTransfer getEmployee(@PathParam("id") long id) {
		return employeeService.retrieve(id);
	}

	// ** Method to delete
	@DELETE
	@Path(value = "{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(@PathParam("id") long id) {
		employeeService.delete(id);
		return Response.status(Status.OK)
				.entity("employee has been successfully deleted")
				.type(MediaType.APPLICATION_JSON).build();
	}

	// **Method to update
	@PUT
	@Path(value = "{id}")
	public EmployeeTransfer updateEmployee(@PathParam("id") long id,
			Employee employee) {
		return employeeService.update(id, employee);
	}

	// **Method to save or create
	@POST
	public EmployeeTransfer saveEmployee(Employee employee) {
		return employeeService.save(employee);
	}

	// ** Method to find All the employees in the list

	@GET
	public Collection<EmployeeTransfer> findallEmployee() {
		return employeeService.findAll();
	}

	// @GET
	// public UserTransfer getEmployee() {
	// Authentication authentication = SecurityContextHolder.getContext()
	// .getAuthentication();
	// Object principal = authentication.getPrincipal();
	// if (principal instanceof String
	// && ((String) principal).equals("anonymousUser")) {
	// throw new WebApplicationException(401);
	// }
	// UserDetails userDetails = (UserDetails) principal;
	//
	// return new UserTransfer(userDetails.getUsername(),
	// this.createRoleMap(userDetails));
	// }

	// private Map<String, Boolean> createRoleMap(UserDetails userDetails) {
	// Map<String, Boolean> roles = new HashMap<String, Boolean>();
	// for (GrantedAuthority authority : userDetails.getAuthorities()) {
	// roles.put(authority.getAuthority(), Boolean.TRUE);
	// }
	// return roles;
	// }

}
