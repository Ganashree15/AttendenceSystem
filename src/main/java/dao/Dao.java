package dao;

import java.util.List;

import entity.AbstractEntity;

public interface Dao<T extends AbstractEntity, I> {

	List<T> findAll();

	T find(I id);

	T save(T newsEntry);

	void delete(I id);

}
