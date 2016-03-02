package com.br.entity;

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
	private Date _dataReserva;
	@Temporal(TemporalType.TIMESTAMP)
	private Date _dataMarcada;			
	@Column(nullable=false)
	private int _nPessoas;			// Numero de pessoas para reserva
	@Column(nullable=false)
	private	String _nomeResp;  		// Nome do Responsavel
	
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
		return _dataReserva;
	}
	public void set_dataReserva(Date _dataReserva) {
		this._dataReserva = _dataReserva;
	}
	public Date get_dataMarcada() {
		return _dataMarcada;
	}
	public void set_dataMarcada(Date _dataMarcada) {
		this._dataMarcada = _dataMarcada;
	}
	public int get_nPessoas() {
		return _nPessoas;
	}
	public void set_nPessoas(int _nPessoas) {
		this._nPessoas = _nPessoas;
	}
	public String get_nomeResp() {
		return _nomeResp;
	}
	public void set_nomeResp(String _nomeResp) {
		this._nomeResp = _nomeResp;
	}
	
}
