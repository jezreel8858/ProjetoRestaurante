package com.br.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Funcionario extends Usuario{
	
	@Column(nullable=false)
	private float salario;
	@Column(nullable=false,length=11)
	private String cpf;
	
	@OneToMany
	@JoinTable(name="Fun_Ped",
				joinColumns=@JoinColumn(name="Fun_Id"),
				inverseJoinColumns=@JoinColumn(name="Ped_Id"))
	private Collection<Pedido> pedidos;
	
	@OneToMany
	@JoinTable(name="Fun_Reserv",
				joinColumns=@JoinColumn(name="Fun_Id"),
				inverseJoinColumns=@JoinColumn(name="Reserv_Id"))
	private Collection<Reserva> reservas;
	
	@ManyToOne
	private Loja loja;
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Collection<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(Collection<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public Collection<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(Collection<Reserva> reservas) {
		this.reservas = reservas;
	}
	public Loja getLoja() {
		return loja;
	}
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
}
