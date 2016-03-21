package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Tradicional;

public class TradicionalDAO extends GenericDAO<Tradicional> {

	public TradicionalDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Tradicional> getClassType() {
		return Tradicional.class;
	}
	
}
