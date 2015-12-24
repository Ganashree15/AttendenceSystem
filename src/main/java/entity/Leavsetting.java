package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * In this example we will use Employee as entity.Id, firstname, lastname,
 * birthdate, cellphone, jobtitle, username, createddate, email, password and
 * gender are the attributes of this entity. It contains default constructor,
 * setter and getter methods of those attributes.
 * 
 */

@Entity
@Table(name = "leavesetting")

public class Leavsetting implements Serializable {
	private static final long serialVersionUID = 7711505597348200997L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "official", nullable = false)
	private Long official;

	@Column(name = "personal", nullable = false)
	private Long personal;

	@Column(name = "sick", nullable = false)
	private Long sick;

	@Column(name = "special", nullable = false)
	private Long special;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getOfficial() {
		return official;
	}

	public void setOfficial(Long official) {
		this.official = official;
	}

	public Long getPersonal() {
		return personal;
	}

	public void setPersonal(Long personal) {
		this.personal = personal;
	}

	public Long getSick() {
		return sick;
	}

	public void setSick(Long sick) {
		this.sick = sick;
	}

	public Long getSpecial() {
		return special;
	}

	public void setSpecial(Long special) {
		this.special = special;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((official == null) ? 0 : official.hashCode());
		result = prime * result + ((personal == null) ? 0 : personal.hashCode());
		result = prime * result + ((sick == null) ? 0 : sick.hashCode());
		result = prime * result + ((special == null) ? 0 : special.hashCode());
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
		Leavsetting other = (Leavsetting) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (official == null) {
			if (other.official != null)
				return false;
		} else if (!official.equals(other.official))
			return false;
		if (personal == null) {
			if (other.personal != null)
				return false;
		} else if (!personal.equals(other.personal))
			return false;
		if (sick == null) {
			if (other.sick != null)
				return false;
		} else if (!sick.equals(other.sick))
			return false;
		if (special == null) {
			if (other.special != null)
				return false;
		} else if (!special.equals(other.special))
			return false;
		return true;
	}

	public Leavsetting(Long id, String name, Long official, Long personal, Long sick, Long special) {
		super();
		this.id = id;
		this.name = name;
		this.official = official;
		this.personal = personal;
		this.sick = sick;
		this.special = special;
	}

	public Leavsetting() {
		super();
		// TODO Auto-generated constructor stub
	}

}
