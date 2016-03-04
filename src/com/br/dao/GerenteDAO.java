package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Gerente;

public class GerenteDAO extends GenericDAO<Gerente> {
	
	public GerenteDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Gerente> getClassType() {
		return Gerente.class;
	}
}
