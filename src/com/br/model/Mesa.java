package com.br.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@OneToMany(mappedBy="mesa")
//	@JoinTable(name="Mesa_Reserv",
//				joinColumns=@JoinColumn(name="Mesa_Id"),
//				inverseJoinColumns=@JoinColumn(name="Reserv_Id"))
	private List<Reserva> reservas;
	

	@OneToMany(mappedBy="mesa")
	private List<Tradicional> tradicionais;
	
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
