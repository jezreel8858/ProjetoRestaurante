package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Delivery;

public class DeliveryDAO extends GenericDAO<Delivery>{

	public DeliveryDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Delivery> getClassType() {
		return Delivery.class;
	}
}
