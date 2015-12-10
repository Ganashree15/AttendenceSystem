package api.data;

import java.io.Serializable;
import java.sql.Date;

/**
 * It is common to make fields private in encapsulation. This means that they
 * can only be directly accessed from the Employee class. We still need access
 * these values, however. This can be done indirectly by adding public methods
 * that obtain the getter and setter field values for us:
 * 
 */

public class Employee implements Serializable {

	private static final long serialVersionUID = -5183069099661541090L;

	private Long id;
	private String firstName;
	private String lastName;
	private Date dateofbirth;
	private String jobtitle;
	private String username;
	private Date createddate;
	private String email;
	private String password;
	private String gender;

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}