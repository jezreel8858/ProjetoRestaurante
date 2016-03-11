package com.br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class GenericDAO<T> {
	
	protected EntityManager manager;
	
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
	
	public List<T> listar() {
		Query query = manager.createQuery("select p from "
				+ getClassType().getSimpleName() + " p");
		return  query.getResultList();
	}
	
	public abstract Class<T> getClassType();
}
