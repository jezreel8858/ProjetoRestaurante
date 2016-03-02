package com.br.entity;

import java.util.Collection;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Check;

@Entity
@Table(name="table_Pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date data;	
	
	@Column(name="status",nullable=false,length=20)
	@Check(constraints = "status IN ('Pendente','Finalizado','Atendido','Cancelado')")
	private String status;
	
	@OneToMany
	@JoinColumn(name="itemC_id")
	private Collection<ItemCardapio> itemPedidos;
	
	@OneToMany
	@JoinTable(name="Ped_ItemC",
				joinColumns=@JoinColumn(name="Ped_Id"),
				inverseJoinColumns=@JoinColumn(name="ItemC_Id"))
	private Collection<ItemCardapio> itemCardapios;
	
	@ManyToOne
	private Loja loja;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}


