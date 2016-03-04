package com.br.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Cliente extends Usuario {
		
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;	
	
	@Temporal(TemporalType.DATE)
	private Date dataNasc;
	
	@Embedded
	private Endereco endereco;

	@OneToMany(mappedBy="cliente")
	private Collection<Delivery> deliverys;
	

	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String toString(){
		return String.format("Nome: %s\nCliente desde: %s\nData de Nascimento: %s\n",
							this.nome,this.dataCadastro,this.dataNasc,this.endereco );
	}
	public Collection<Delivery> getDeliverys() {
		return deliverys;
	}
	public void setDeliverys(Collection<Delivery> deliverys) {
		this.deliverys = deliverys;
	}
}
