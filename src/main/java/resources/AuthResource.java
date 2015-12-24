package resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import service.EmployeeService;
import transfer.EmployeeTransfer;
import transfer.TokenTransfer;
import util.TokenUtils;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/auth")
public class AuthResource {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private UserDetailsService userService;

	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authManager;

	@Path("authenticate")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public TokenTransfer authenticate(@FormParam("username") String username,
			@FormParam("password") String password) {
		UsernamePasswordAuthenticationToken authenticatinoToken = new UsernamePasswordAuthenticationToken(
				username, password);
		Authentication authentication = this.authManager
				.authenticate(authenticatinoToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetails userDetails = this.userService.loadUserByUsername(username);
		EmployeeTransfer employeeTransfer = employeeService
				.findByUsername(username);
		return new TokenTransfer(employeeTransfer.getId(),
				TokenUtils.createToken(userDetails));
	}

}
