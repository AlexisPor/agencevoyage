package persistence.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T> {
	
	void add(T entity);
	
	void delete(T entity);
	
	void update(T entity);
	
	List<T> findAll();
	
	T findById(Serializable o);

}
