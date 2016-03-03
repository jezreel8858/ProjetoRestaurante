package com.br.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Delivery extends Pedido {

	private float troco;

	@ManyToOne
	private Cliente cliente;
	
	public float getTroco() {
		return troco;
	}

	public void setTroco(float troco) {
		this.troco = troco;
	}
	public String toString(){
		return String.format("Troco: %f", this.troco);
	}
}
