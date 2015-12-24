package entity;

import java.io.Serializable;
import java.security.MessageDigest;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.codec.binary.Hex;

/**
 * In this example we will use Employee as entity.Id, firstname, lastname,
 * birthdate, cellphone, jobtitle, username, createddate, email, password and
 * gender are the attributes of this entity. It contains default constructor,
 * setter and getter methods of those attributes.
 * 
 */

@Entity
@Table(name = "user_shared")

public class EmployeeEntity implements Serializable {
	private static final long serialVersionUID = 7711505597348200997L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "date_of_birth", nullable = false)
	private Date dateofbirth;

	@Column(name = "job_title", nullable = false)
	private String jobtitle;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "created_date", nullable = false)
	private Date createddate;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "gender", nullable = false)
	private String gender;

	public EmployeeEntity() {

	}

	public EmployeeEntity(Long id, String firstName, String lastName, Date birthdate, String phone, String jobtitle,
			String username, Date createddate, String email, String password, String gender) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateofbirth = birthdate;
		this.jobtitle = jobtitle;
		this.username = username;
		this.createddate = createddate;
		this.email = email;
		this.password = hashPassword(password);
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
		this.password = hashPassword(password);
	}

	private String hashPassword(String password) {
		// private String digestAlgorithm="SHA-1";
		// private String charset="UTF-8";
		try {

			MessageDigest digest = MessageDigest.getInstance("SHA1");
			digest.update(password.getBytes("UTF-8"));
			byte[] rawHash = digest.digest();
			return new String(Hex.encodeHex(rawHash));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	// ======= Implements =======

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeEntity other = (EmployeeEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}