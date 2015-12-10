package persistence;

import java.sql.Date;
import java.util.Collection;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import api.data.Employee;
import entity.EmployeeEntity;

/**
 * One implementation of the interface for Employees Data acess model
 * 
 */

@Singleton
public class EmployeeDaoImpl implements EmployeeDao {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Attendence");

	/**
	 * Retrieve is used to find the employee entity present in the model and
	 * gives us the required data
	 */

	@Override
	public EmployeeEntity retrieve(long id) {
		EntityManager em = emf.createEntityManager();

		EmployeeEntity entity = null;

		try {
			entity = em.find(EmployeeEntity.class, id);
		} finally {
			em.close();
		}

		if (entity == null) {
			throw new WebApplicationException("invalid id:" + id, Response.Status.NOT_FOUND);
		}

		return entity;
	}

	/**
	 * delete method is used to delete the data which is not required in the
	 * employee entity
	 * 
	 */

	@Override
	public void delete(long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		EmployeeEntity entity = null;
		try {
			transaction.begin();
			entity = em.find(EmployeeEntity.class, id);

			if (entity != null) {
				em.remove(entity);
			}

			transaction.commit();
		} catch (Exception e) {
			logger.error("Error Deleting Employee: " + e.getMessage());
			transaction.rollback();
			throw e;
		} finally {
			em.close();
		}
		if (entity == null) {
			throw new WebApplicationException("invalid id:" + id, Response.Status.NOT_FOUND);
		}
	}

	/**
	 * create the employee entity
	 * 
	 */

	@Override
	public void save(EmployeeEntity employee) {
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();

			em.persist(employee);

			transaction.commit();
		} catch (Exception e) {
			logger.error("Error Saving Employee: " + e.getMessage());
			transaction.rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	@Override
	public void update(int id, String FirstName, String LastName, String jobtitle, String username, String email,
			String password, String gender, Date dateofbirth, Date createddate) {
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();

			Employee e = em.find(Employee.class, id);
			if (e != null) {
				e.setFirstName(FirstName);
				e.setLastName(LastName);
				e.setCreateddate(createddate);
				e.setDateofbirth(dateofbirth);
				e.setEmail(email);
				e.setGender(gender);
				e.setJobtitle(jobtitle);
				e.setPassword(password);
				e.setUsername(username);
				em.merge(e);
			}

			transaction.commit();
		} catch (Exception e) {
			logger.info("Error updating Employee: ");
			transaction.rollback();
			throw e;
		} finally {
			em.close();

		}
	}

	/**
	 * used to find all entity present in the employee table to achieve this
	 * criteriaQuery method is used
	 */

	@Override
	public Collection<EmployeeEntity> findAll() {
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();

			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<EmployeeEntity> cq = cb.createQuery(EmployeeEntity.class);
			Root<EmployeeEntity> rootEntry = cq.from(EmployeeEntity.class);
			CriteriaQuery<EmployeeEntity> all = cq.select(rootEntry);
			TypedQuery<EmployeeEntity> allQuery = em.createQuery(all);
			return allQuery.getResultList();

		} catch (Exception e) {
			logger.error("Error finding Employee: " + e.getMessage());
			throw e;
		} finally {
			em.close();
		}
	}

	// @Override
	// public EmployeeEntity findByName(String name, String password) {
	// EntityManager em = emf.createEntityManager();

	// EntityTransaction transaction = em.getTransaction();
	// try {
	// transaction.begin();

	// CriteriaBuilder cb = em.getCriteriaBuilder();
	// CriteriaQuery<EmployeeEntity> cq = cb.createQuery(EmployeeEntity.class);
	// Root<EmployeeEntity> rootEntry = cq.from(EmployeeEntity.class);
	// CriteriaQuery<EmployeeEntity> all = cq.select(rootEntry);
	// all.where(cb.equal(rootEntry.get("username"), name),
	// cb.equal(rootEntry.get("password"), password));
	// TypedQuery<EmployeeEntity> allQuery = em.createQuery(all);
	// return allQuery.getSingleResult();

	// } catch (Exception e) {
	// logger.error("Error finding Employee: " + e.getMessage());
	// throw e;
	// } finally {
	// em.close();
	// }
	// }

}