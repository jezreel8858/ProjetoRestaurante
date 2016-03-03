package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Pedido;

public class PedidoDAO extends GenericDAO<Pedido>{

	public PedidoDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Pedido> getClassType() {
		return Pedido.class;
	}

}
