package com.br.dao;

import javax.persistence.EntityManager;

public abstract class GenericDAO<T> {
	
	private EntityManager manager;
	
	public GenericDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void insert(T entity){
		manager.persist(entity);
	}
	
	public T findById(Long id){
		return manager.find(getClassType(), id);
	}
	
	public void update(T entity){
		manager.merge(entity);
	}
	
	public void delete(T entity){
		manager.remove(entity);
	}
	
	public abstract Class<T> getClassType();
}
