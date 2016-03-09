package com.br.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	private List<Pedido> pedidos;
		
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
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}
