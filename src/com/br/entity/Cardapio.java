package com.br.entity;


import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="table_Cardapio")
public class Cardapio {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false,length=50)	
	private String nome;
	
	@Column(nullable=false)
	private float preco;
	
	@ManyToOne
	@JoinColumn(name="categ_id")
	private Categoria categoria;
	
	@OneToMany
	@JoinTable(name="Card_ItemC",
				joinColumns=@JoinColumn(name="Card_Id"),
				inverseJoinColumns=@JoinColumn(name="ItemC_Id"))
	private Collection<ItemCardapio> itemCardapios;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
}
