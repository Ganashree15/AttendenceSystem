package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

import entity.AbstractEntity;

public class JpaDao<T extends AbstractEntity, I> implements Dao<T, I> {

	private EntityManager entityManager;

	protected Class<T> entityClass;

	public JpaDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@PersistenceContext
	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> findAll() {
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> cq = builder.createQuery(this.entityClass);
		cq.from(this.entityClass);
		TypedQuery<T> typedQuery = this.getEntityManager().createQuery(cq);
		return typedQuery.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public T find(I id) {
		return this.getEntityManager().find(this.entityClass, id);
	}

	@Override
	@Transactional
	public T save(T entity) {
		return this.getEntityManager().merge(entity);
	}

	@Override
	@Transactional
	public void delete(I id) {
		if (id == null) {
			return;
		}
		T entity = this.find(id);
		if (entity == null) {
			return;
		}
		this.getEntityManager().remove(entity);
	}

}
