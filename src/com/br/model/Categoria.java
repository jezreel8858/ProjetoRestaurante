package com.br.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="table_Categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false,length=50)	
	private String nome;
	
	@OneToMany
	@JoinTable(name="Categ_Card",
				joinColumns=@JoinColumn(name="Categ_Id"),
				inverseJoinColumns=@JoinColumn(name="Card_Id"))
	private Collection<Cardapio> Cardapios;
	
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

	
}
