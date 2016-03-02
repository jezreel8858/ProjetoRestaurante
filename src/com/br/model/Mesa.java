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

@Entity
public class Mesa {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false,unique=true)
	private int numero;
	@Column(nullable=false)
	private int capacidade;
	
	@OneToMany
	@JoinTable(name="Mesa_Reserv",
				joinColumns=@JoinColumn(name="Mesa_Id"),
				inverseJoinColumns=@JoinColumn(name="Reserv_Id"))
	private Collection<Reserva> reservas;
	

	@OneToMany
	@JoinTable(name="Mesa_Trad",
				joinColumns=@JoinColumn(name="Mesa_Id"),
				inverseJoinColumns=@JoinColumn(name="Trad_Id"))
	private Collection<Tradicional> tradicionais;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	

}
