package com.br.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="table_itemCardapio")
public class ItemCardapio {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="quantidade",nullable=false,length=50)	
	private int qtd;
	
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	
	@ManyToOne
	//@JoinTable(name="item_card",
	//	joinColumns=@JoinColumn(name="item_id"),
	//	inverseJoinColumns=@JoinColumn(name="cardapio_id"))
	@JoinColumn(name="item_id")
	private Cardapio cardapio;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Cardapio getCardapio() {
		return cardapio;
	}
	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	
}
