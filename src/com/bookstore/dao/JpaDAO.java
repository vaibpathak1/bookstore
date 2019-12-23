package com.bookstore.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JpaDAO<E> {
	protected EntityManager entityManager;
	public JpaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	 
	public E create (E t) {
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.flush();
		entityManager.refresh(t);
		entityManager.getTransaction().commit();
		return t;
	}
	
	public E Update (E t) {
		entityManager.getTransaction().begin();
		entityManager.merge(t);
		entityManager.getTransaction().commit();
		return t;
	}
	
	public E find (Class<E> type,Object id) {
		E find = entityManager.find(type, id);
		if (find !=null) {
		entityManager.refresh(find);
		}
		return find;
	}
	
	public void delete (Class<E> type,Object id) {
		entityManager.getTransaction().begin();
		Object reference = entityManager.getReference(type, id);
		entityManager.remove(reference);
		entityManager.getTransaction().commit();
	}
	
	/*public List<E> findWithNamedQuery (String queryname,Map<String,Object> parameter) {
		Query createNamedQuery = entityManager.createNamedQuery(queryname);
		createNamedQuery.setParameter(position, value)
		return createNamedQuery.getResultList();
	}*/
	
	public List<E> findWithNamedQuery (String queryname,String paramName,String value) {
		Query createNamedQuery = entityManager.createNamedQuery(queryname);
		createNamedQuery.setParameter(paramName, value);
		return createNamedQuery.getResultList();
	}
	public List<E> findWithNamedQuery (String queryname,Map<String, Object> parameters) {
		Query createNamedQuery = entityManager.createNamedQuery(queryname);
		Set<Entry<String, Object>> entrySet = parameters.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			createNamedQuery.setParameter(entry.getKey(), entry.getValue());
		}
		
		return createNamedQuery.getResultList();
	}
	
	public List<E> findWithNamedQuery (String queryname) {
		Query createNamedQuery = entityManager.createNamedQuery(queryname);
		return createNamedQuery.getResultList();
	}
	public long count (String queryname) {
		Query createNamedQuery = entityManager.createNamedQuery(queryname);
		return (long) createNamedQuery.getSingleResult();
	}
	

}
