package entity;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "employee")
public class Employee extends AbstractEntity implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1154129853752708026L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "responseto")
	private Employee employee;
	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "job_id", nullable = false)
	// private JobType jobType;
	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "department_id", nullable = false)
	// private Department department;
	@Column(name = "name", nullable = false, length = 20)
	private String name;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateofbirth", nullable = false, length = 13)
	private Date dateofbirth;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateofjoined", nullable = false, length = 13)
	private Date dateofjoined;
	@Column(name = "password", nullable = false, length = 100)
	private String password;
	@Column(name = "username", unique = true, nullable = false, length = 20)
	private String username;
	@Column(name = "email", unique = true, nullable = false, length = 40)
	private String email;
	// @Column(name = "gender", nullable = false, length = 20)
	// @Enumerated(EnumType.STRING)
	// private Gender gender;
	@Column(name = "comment")
	private String comment;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<Employee> employees = new HashSet<Employee>(0);
	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	// private Set<Department> departments = new HashSet<Department>(0);
	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByPermicPersonId")
	// private Set<AttendRecord> attendRecordsForPermicPersonId = new
	// HashSet<AttendRecord>(
	// 0);
	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeByEmployeeId")
	// private Set<AttendRecord> attendRecordsForEmployeeId = new
	// HashSet<AttendRecord>(
	// 0);
	@Column(name = "color")
	private String color;

	@Column(name = "specialleave")
	private float specialleave;

	@Column(name = "specialleave_used")
	private float specialleave_used;

	@Column(name = "sick")
	private float sick;

	@Column(name = "sick_used")
	private float sick_used;

	@Column(name = "personal")
	private float personal;

	@Column(name = "personal_used")
	private float personal_used;

	@Column(name = "official_used")
	private float official_used;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "leaveSetting")
	// private LeaveSetting leaveSetting;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "employee_role", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<Role>();
	@Column(name = "lastlogin")
	private Date lastLogin;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles = this.getRoles();
		if (roles == null) {
			return Collections.emptyList();
		}

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return authorities;
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getSpecialleave() {
		return specialleave;
	}

	public void setSpecialleave(float specialleave) {
		this.specialleave = specialleave;
	}

	public float getSpecialleave_used() {
		return specialleave_used;
	}

	public void setSpecialleave_used(float specialleave_used) {
		this.specialleave_used = specialleave_used;
	}

	public float getSick() {
		return sick;
	}

	public void setSick(float sick) {
		this.sick = sick;
	}

	public float getSick_used() {
		return sick_used;
	}

	public void setSick_used(float sick_used) {
		this.sick_used = sick_used;
	}

	public float getPersonal() {
		return personal;
	}

	public void setPersonal(float personal) {
		this.personal = personal;
	}

	public float getPersonal_used() {
		return personal_used;
	}

	public void setPersonal_used(float personal_used) {
		this.personal_used = personal_used;
	}

	public float getOfficial_used() {
		return official_used;
	}

	public void setOfficial_used(float official_used) {
		this.official_used = official_used;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
