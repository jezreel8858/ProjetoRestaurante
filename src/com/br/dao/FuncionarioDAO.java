package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Funcionario;

public class FuncionarioDAO extends GenericDAO<Funcionario>{

	public FuncionarioDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Funcionario> getClassType() {
		return Funcionario.class;
	}
}
