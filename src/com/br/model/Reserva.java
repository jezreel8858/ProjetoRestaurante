package com.br.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataReserva;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataMarcada;			
	@Column(nullable=false)
	private int nPessoas;			// Numero de pessoas para reserva
	@Column(nullable=false)
	private	String nomeResp;  		// Nome do Responsavel
	
	@ManyToOne
	@JoinColumn(name="fun_id")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name="mesa_id")
	private Mesa mesa;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date get_dataReserva() {
		return dataReserva;
	}
	public void set_dataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}
	public Date get_dataMarcada() {
		return dataMarcada;
	}
	public void set_dataMarcada(Date dataMarcada) {
		this.dataMarcada = dataMarcada;
	}
	public int get_nPessoas() {
		return nPessoas;
	}
	public void set_nPessoas(int nPessoas) {
		this.nPessoas = nPessoas;
	}
	public String get_nomeResp() {
		return nomeResp;
	}
	public void set_nomeResp(String nomeResp) {
		this.nomeResp = nomeResp;
	}
	
}
