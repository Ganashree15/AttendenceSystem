package entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "attend_record")

public class Attend_record implements Serializable {
	private static final long serialVersionUID = 7711505597348200997L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "end_date", nullable = false)
	private Timestamp end_date;

	@Column(name = "duration", nullable = false)
	private Timestamp duration;

	@Column(name = "reason", nullable = false)
	private String reason;

	@Column(name = "permit", nullable = false)
	private String permit;

	@Column(name = "employee_id", nullable = false)
	private Long employee_id;

	@Column(name = "modify_date", nullable = false)
	private Timestamp modify_date;

	@Column(name = "modify_start_date", nullable = false)
	private Timestamp modify_start_date;

	@Column(name = "modify_end_date", nullable = false)
	private Timestamp modify_end_date;

	@Column(name = "book_date", nullable = false)
	private Timestamp book_date;

	@Column(name = "start_date", nullable = false)
	private Timestamp start_date;

	@Column(name = "permic_person_id", nullable = false)
	private Long permic_person_id;

	@Column(name = "dateinterval", nullable = false)
	private Date dateinterval;

	@Column(name = "endperiod", nullable = false)
	private Date endperiod;

	@Column(name = "modifyendperiod", nullable = false)
	private Date modifyendperiod;

	@Column(name = "modifystartperiod", nullable = false)
	private Date modifystartperiod;

	@Column(name = "modifypermit", nullable = false)
	private String modifypermit;

	@Column(name = "period", nullable = false)
	private Date period;

	@Column(name = "startperiod", nullable = false)
	private Date startperiod;

	@Column(name = "modifydateinterval", nullable = false)
	private Date modifydateinterval;

	@Column(name = "permit2", nullable = false)
	private String permit2;

	@Column(name = "permic_person_id2", nullable = false)
	private Long permic_person_id2;

	public Attend_record(Long id, Timestamp modify_end_date, Timestamp modify_start_date, Timestamp modify_date,
			Long employee_id, String permit, String reason, Timestamp duration, Timestamp end_date, Timestamp book_date,
			Timestamp start_date, Long permic_person_id, Date dateinterval, Date endperiod, Date modifyendperiod,
			Date modifystartperiod, String modifypermit, Date startperiod, Date period, String permit2,
			String modifypermit2, String modifyreason, String modifytype, Long permic_person_id2) {
		super();
		this.id = id;
		this.book_date = book_date;
		this.dateinterval = dateinterval;
		this.duration = duration;
		this.employee_id = employee_id;
		this.end_date = end_date;
		this.endperiod = endperiod;
		this.modify_date = modify_date;
		this.modify_end_date = modify_end_date;
		this.modify_start_date = modify_start_date;
		this.modifydateinterval = modifydateinterval;
		this.modifyendperiod = modifyendperiod;
		this.modifypermit = modifypermit;
		this.modifypermit2 = modifypermit2;
		this.modifyreason = modifyreason;
		this.modifystartperiod = modifystartperiod;
		this.modifytype = modifytype;
		this.period = period;
		this.permic_person_id = permic_person_id;
		this.permit = permit;
		this.permit2 = permit2;
		this.reason = reason;
		this.start_date = start_date;
		this.startperiod = startperiod;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}

	public Timestamp getDuration() {
		return duration;
	}

	public void setDuration(Timestamp duration) {
		this.duration = duration;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPermit() {
		return permit;
	}

	public void setPermit(String permit) {
		this.permit = permit;
	}

	public Long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}

	public Timestamp getModify_date() {
		return modify_date;
	}

	public void setModify_date(Timestamp modify_date) {
		this.modify_date = modify_date;
	}

	public Timestamp getModify_start_date() {
		return modify_start_date;
	}

	public void setModify_start_date(Timestamp modify_start_date) {
		this.modify_start_date = modify_start_date;
	}

	public Timestamp getModify_end_date() {
		return modify_end_date;
	}

	public void setModify_end_date(Timestamp modify_end_date) {
		this.modify_end_date = modify_end_date;
	}

	public Timestamp getBook_date() {
		return book_date;
	}

	public void setBook_date(Timestamp book_date) {
		this.book_date = book_date;
	}

	public Timestamp getStart_date() {
		return start_date;
	}

	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}

	public Long getPermic_person_id() {
		return permic_person_id;
	}

	public void setPermic_person_id(Long permic_person_id) {
		this.permic_person_id = permic_person_id;
	}

	public Date getDateinterval() {
		return dateinterval;
	}

	public void setDateinterval(Date dateinterval) {
		this.dateinterval = dateinterval;
	}

	public Date getEndperiod() {
		return endperiod;
	}

	public void setEndperiod(Date endperiod) {
		this.endperiod = endperiod;
	}

	public Date getModifyendperiod() {
		return modifyendperiod;
	}

	public void setModifyendperiod(Date modifyendperiod) {
		this.modifyendperiod = modifyendperiod;
	}

	public Date getModifystartperiod() {
		return modifystartperiod;
	}

	public void setModifystartperiod(Date modifystartperiod) {
		this.modifystartperiod = modifystartperiod;
	}

	public String getModifypermit() {
		return modifypermit;
	}

	public void setModifypermit(String modifypermit) {
		this.modifypermit = modifypermit;
	}

	public Date getPeriod() {
		return period;
	}

	public void setPeriod(Date period) {
		this.period = period;
	}

	public Date getStartperiod() {
		return startperiod;
	}

	public void setStartperiod(Date startperiod) {
		this.startperiod = startperiod;
	}

	public Date getModifydateinterval() {
		return modifydateinterval;
	}

	public void setModifydateinterval(Date modifydateinterval) {
		this.modifydateinterval = modifydateinterval;
	}

	public String getPermit2() {
		return permit2;
	}

	public void setPermit2(String permit2) {
		this.permit2 = permit2;
	}

	public Long getPermic_person_id2() {
		return permic_person_id2;
	}

	public void setPermic_person_id2(Long permic_person_id2) {
		this.permic_person_id2 = permic_person_id2;
	}

	public String getModifypermit2() {
		return modifypermit2;
	}

	public void setModifypermit2(String modifypermit2) {
		this.modifypermit2 = modifypermit2;
	}

	public String getModifyreason() {
		return modifyreason;
	}

	public void setModifyreason(String modifyreason) {
		this.modifyreason = modifyreason;
	}

	public String getModifytype() {
		return modifytype;
	}

	public void setModifytype(String modifytype) {
		this.modifytype = modifytype;
	}

	@Column(name = "modifypermit2", nullable = false)
	private String modifypermit2;

	@Column(name = "modifyreason", nullable = false)
	private String modifyreason;

	@Column(name = "modifytype", nullable = false)
	private String modifytype;

	public Attend_record() {
		super();

	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.REMOVE)
	private Set<Attend_record> records = new HashSet<Attend_record>(0);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book_date == null) ? 0 : book_date.hashCode());
		result = prime * result + ((dateinterval == null) ? 0 : dateinterval.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((employee_id == null) ? 0 : employee_id.hashCode());
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
		result = prime * result + ((endperiod == null) ? 0 : endperiod.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modify_date == null) ? 0 : modify_date.hashCode());
		result = prime * result + ((modify_end_date == null) ? 0 : modify_end_date.hashCode());
		result = prime * result + ((modify_start_date == null) ? 0 : modify_start_date.hashCode());
		result = prime * result + ((modifydateinterval == null) ? 0 : modifydateinterval.hashCode());
		result = prime * result + ((modifyendperiod == null) ? 0 : modifyendperiod.hashCode());
		result = prime * result + ((modifypermit == null) ? 0 : modifypermit.hashCode());
		result = prime * result + ((modifypermit2 == null) ? 0 : modifypermit2.hashCode());
		result = prime * result + ((modifyreason == null) ? 0 : modifyreason.hashCode());
		result = prime * result + ((modifystartperiod == null) ? 0 : modifystartperiod.hashCode());
		result = prime * result + ((modifytype == null) ? 0 : modifytype.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		result = prime * result + ((permic_person_id == null) ? 0 : permic_person_id.hashCode());
		result = prime * result + ((permic_person_id2 == null) ? 0 : permic_person_id2.hashCode());
		result = prime * result + ((permit == null) ? 0 : permit.hashCode());
		result = prime * result + ((permit2 == null) ? 0 : permit2.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		result = prime * result + ((startperiod == null) ? 0 : startperiod.hashCode());
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
		Attend_record other = (Attend_record) obj;
		if (book_date == null) {
			if (other.book_date != null)
				return false;
		} else if (!book_date.equals(other.book_date))
			return false;
		if (dateinterval == null) {
			if (other.dateinterval != null)
				return false;
		} else if (!dateinterval.equals(other.dateinterval))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (employee_id == null) {
			if (other.employee_id != null)
				return false;
		} else if (!employee_id.equals(other.employee_id))
			return false;
		if (end_date == null) {
			if (other.end_date != null)
				return false;
		} else if (!end_date.equals(other.end_date))
			return false;
		if (endperiod == null) {
			if (other.endperiod != null)
				return false;
		} else if (!endperiod.equals(other.endperiod))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modify_date == null) {
			if (other.modify_date != null)
				return false;
		} else if (!modify_date.equals(other.modify_date))
			return false;
		if (modify_end_date == null) {
			if (other.modify_end_date != null)
				return false;
		} else if (!modify_end_date.equals(other.modify_end_date))
			return false;
		if (modify_start_date == null) {
			if (other.modify_start_date != null)
				return false;
		} else if (!modify_start_date.equals(other.modify_start_date))
			return false;
		if (modifydateinterval == null) {
			if (other.modifydateinterval != null)
				return false;
		} else if (!modifydateinterval.equals(other.modifydateinterval))
			return false;
		if (modifyendperiod == null) {
			if (other.modifyendperiod != null)
				return false;
		} else if (!modifyendperiod.equals(other.modifyendperiod))
			return false;
		if (modifypermit == null) {
			if (other.modifypermit != null)
				return false;
		} else if (!modifypermit.equals(other.modifypermit))
			return false;
		if (modifypermit2 == null) {
			if (other.modifypermit2 != null)
				return false;
		} else if (!modifypermit2.equals(other.modifypermit2))
			return false;
		if (modifyreason == null) {
			if (other.modifyreason != null)
				return false;
		} else if (!modifyreason.equals(other.modifyreason))
			return false;
		if (modifystartperiod == null) {
			if (other.modifystartperiod != null)
				return false;
		} else if (!modifystartperiod.equals(other.modifystartperiod))
			return false;
		if (modifytype == null) {
			if (other.modifytype != null)
				return false;
		} else if (!modifytype.equals(other.modifytype))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		if (permic_person_id == null) {
			if (other.permic_person_id != null)
				return false;
		} else if (!permic_person_id.equals(other.permic_person_id))
			return false;
		if (permic_person_id2 == null) {
			if (other.permic_person_id2 != null)
				return false;
		} else if (!permic_person_id2.equals(other.permic_person_id2))
			return false;
		if (permit == null) {
			if (other.permit != null)
				return false;
		} else if (!permit.equals(other.permit))
			return false;
		if (permit2 == null) {
			if (other.permit2 != null)
				return false;
		} else if (!permit2.equals(other.permit2))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		if (startperiod == null) {
			if (other.startperiod != null)
				return false;
		} else if (!startperiod.equals(other.startperiod))
			return false;
		return true;
	}

}
