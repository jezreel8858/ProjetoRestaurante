package com.br.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="table_Pedido")
@Inheritance(strategy=InheritanceType.JOINED)
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date data;	
	
	private String status;
	
	@OneToMany(mappedBy="pedido")
	private List<ItemCardapio> itemCardapios;
	
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
	public List<ItemCardapio> getItemCardapios() {
		return itemCardapios;
	}
	public void setItemCardapios(List<ItemCardapio> itemCardapios) {
		this.itemCardapios = itemCardapios;
	}

}


