package com.br.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Loja {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false,unique=true,length=30)
	private String nome;
	@Column(nullable=false)
	private String cnpj;	
	@Embedded
	private Endereco endereco;
	

	@OneToMany
//	@JoinTable(name="Loja_Ped",
//				joinColumns=@JoinColumn(name="Loja_Id"),
//				inverseJoinColumns=@JoinColumn(name="Ped_Id"))
	@JoinColumn(name="loja_id")
	private Collection<Pedido> pedidos;
}
