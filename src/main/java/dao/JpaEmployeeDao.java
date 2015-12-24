package dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import entity.Employee;

public class JpaEmployeeDao extends JpaDao<Employee, Long> implements
		EmployeeDao {

	public JpaEmployeeDao() {
		super(Employee.class);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Employee user = this.findByName(username);
		if (null == user) {
			throw new UsernameNotFoundException("The employee with name "
					+ username + " was not found");
		}
		return user;
	}

	@Override
	public Employee findByName(String name) {
		CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

		Root<Employee> root = cq.from(Employee.class);
		Path<String> namePath = root.get("username");
		cq.where(cb.equal(namePath, name));
		TypedQuery<Employee> typedQuery = this.getEntityManager().createQuery(
				cq);
		List<Employee> users = typedQuery.getResultList();

		if (users.isEmpty()) {
			return null;
		}

		return users.iterator().next();
	}
}
