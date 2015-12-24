
package entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * In this example we will use Employee as entity.Id, firstname, lastname,
 * birthdate, cellphone, jobtitle, username, createddate, email, password and
 * gender are the attributes of this entity. It contains default constructor,
 * setter and getter methods of those attributes.
 * 
 */

@Entity
@Table(name = "employee")

public class Employee implements Serializable {
	private static final long serialVersionUID = 7711505597348200997L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "lastlogin", nullable = false)
	private Timestamp lastlogin;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "date_of_birth", nullable = false)
	private Date dateofbirth;

	@Column(name = "dateofjoined", nullable = false)
	private Date dateofjoined;

	@Column(name = "job_id", nullable = false)
	private Long job_id;

	@Column(name = "department_id", nullable = false)
	private Long department_id;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "responseto", nullable = false)
	private Long response;

	@Column(name = "color", nullable = false)
	private String color;

	@Column(name = "personal_used", nullable = false)
	private String personal_used;

	@Column(name = "sick_used", nullable = false)
	private String sick_used;

	@Column(name = "specialleave", nullable = false)
	private String specialleave;

	@Column(name = "specailleave_used", nullable = false)
	private String specialleave_used;

	@Column(name = "leavesetting", nullable = false)
	private String leavesetting;

	@Column(name = "personal", nullable = false)
	private String personal;

	@Column(name = "sick", nullable = false)
	private String sick;

	@Column(name = "official_used", nullable = false)
	private Date official_used;

	@ManyToOne
	@JoinColumn(name = "department")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "job_type")
	private Job_type job_type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Timestamp lastlogin) {
		this.lastlogin = lastlogin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public Date getDateofjoined() {
		return dateofjoined;
	}

	public void setDateofjoined(Date dateofjoined) {
		this.dateofjoined = dateofjoined;
	}

	public Long getJob_id() {
		return job_id;
	}

	public void setJob_id(Long job_id) {
		this.job_id = job_id;
	}

	public Long getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
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

	public Long getResponse() {
		return response;
	}

	public void setResponse(Long response) {
		this.response = response;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPersonal_used() {
		return personal_used;
	}

	public void setPersonal_used(String personal_used) {
		this.personal_used = personal_used;
	}

	public String getSick_used() {
		return sick_used;
	}

	public void setSick_used(String sick_used) {
		this.sick_used = sick_used;
	}

	public String getSpecialleave() {
		return specialleave;
	}

	public void setSpecialleave(String specialleave) {
		this.specialleave = specialleave;
	}

	public String getSpecialleave_used() {
		return specialleave_used;
	}

	public void setSpecialleave_used(String specialleave_used) {
		this.specialleave_used = specialleave_used;
	}

	public String getLeavesetting() {
		return leavesetting;
	}

	public void setLeavesetting(String leavesetting) {
		this.leavesetting = leavesetting;
	}

	public String getPersonal() {
		return personal;
	}

	public void setPersonal(String personal) {
		this.personal = personal;
	}

	public String getSick() {
		return sick;
	}

	public void setSick(String sick) {
		this.sick = sick;
	}

	public Date getOfficial_used() {
		return official_used;
	}

	public void setOfficial_used(Date official_used) {
		this.official_used = official_used;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Job_type getJob_type() {
		return job_type;
	}

	public void setJob_type(Job_type job_type) {
		this.job_type = job_type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((dateofbirth == null) ? 0 : dateofbirth.hashCode());
		result = prime * result + ((dateofjoined == null) ? 0 : dateofjoined.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((department_id == null) ? 0 : department_id.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((job_id == null) ? 0 : job_id.hashCode());
		result = prime * result + ((lastlogin == null) ? 0 : lastlogin.hashCode());
		result = prime * result + ((leavesetting == null) ? 0 : leavesetting.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((official_used == null) ? 0 : official_used.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((personal == null) ? 0 : personal.hashCode());
		result = prime * result + ((personal_used == null) ? 0 : personal_used.hashCode());
		result = prime * result + ((response == null) ? 0 : response.hashCode());
		result = prime * result + ((sick == null) ? 0 : sick.hashCode());
		result = prime * result + ((sick_used == null) ? 0 : sick_used.hashCode());
		result = prime * result + ((specialleave == null) ? 0 : specialleave.hashCode());
		result = prime * result + ((specialleave_used == null) ? 0 : specialleave_used.hashCode());
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
		Employee other = (Employee) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (dateofbirth == null) {
			if (other.dateofbirth != null)
				return false;
		} else if (!dateofbirth.equals(other.dateofbirth))
			return false;
		if (dateofjoined == null) {
			if (other.dateofjoined != null)
				return false;
		} else if (!dateofjoined.equals(other.dateofjoined))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (department_id == null) {
			if (other.department_id != null)
				return false;
		} else if (!department_id.equals(other.department_id))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (job_id == null) {
			if (other.job_id != null)
				return false;
		} else if (!job_id.equals(other.job_id))
			return false;
		if (lastlogin == null) {
			if (other.lastlogin != null)
				return false;
		} else if (!lastlogin.equals(other.lastlogin))
			return false;
		if (leavesetting == null) {
			if (other.leavesetting != null)
				return false;
		} else if (!leavesetting.equals(other.leavesetting))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (official_used == null) {
			if (other.official_used != null)
				return false;
		} else if (!official_used.equals(other.official_used))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (personal == null) {
			if (other.personal != null)
				return false;
		} else if (!personal.equals(other.personal))
			return false;
		if (personal_used == null) {
			if (other.personal_used != null)
				return false;
		} else if (!personal_used.equals(other.personal_used))
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		if (sick == null) {
			if (other.sick != null)
				return false;
		} else if (!sick.equals(other.sick))
			return false;
		if (sick_used == null) {
			if (other.sick_used != null)
				return false;
		} else if (!sick_used.equals(other.sick_used))
			return false;
		if (specialleave == null) {
			if (other.specialleave != null)
				return false;
		} else if (!specialleave.equals(other.specialleave))
			return false;
		if (specialleave_used == null) {
			if (other.specialleave_used != null)
				return false;
		} else if (!specialleave_used.equals(other.specialleave_used))
			return false;
		return true;
	}

	public Employee(Long id, Timestamp lastlogin, String name, Date dateofbirth, Date dateofjoined, Long job_id,
			Long department_id, String email, String password, String gender, Long response, String color,
			String personal_used, String sick_used, String specialleave, String specialleave_used, String leavesetting,
			String personal, String sick, Date official_used, Department department, Job_type job_type) {
		super();
		this.id = id;
		this.lastlogin = lastlogin;
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.dateofjoined = dateofjoined;
		this.job_id = job_id;
		this.department_id = department_id;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.response = response;
		this.color = color;
		this.personal_used = personal_used;
		this.sick_used = sick_used;
		this.specialleave = specialleave;
		this.specialleave_used = specialleave_used;
		this.leavesetting = leavesetting;
		this.personal = personal;
		this.sick = sick;
		this.official_used = official_used;
		this.department = department;
		this.job_type = job_type;
	}

	public Employee() {
		super();

	}

}