package transfer;

import java.util.Map;

public class EmployeeTransfer {

	private long id;
	private String name;
	private Map<String, Boolean> roles;

	public EmployeeTransfer() {
		super();
	}

	public EmployeeTransfer(long id, String name, Map<String, Boolean> roles) {
		super();
		this.id = id;
		this.name = name;
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public Map<String, Boolean> getRoles() {
		return roles;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRoles(Map<String, Boolean> roles) {
		this.roles = roles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
