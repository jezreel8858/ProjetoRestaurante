package com.br.view;

import com.br.model.Cardapio;
import com.br.model.Categoria;
import com.br.model.Mesa;
import com.br.model.Tradicional;
import com.br.services.CardapioService;
import com.br.services.CategoriaService;
import com.br.services.MesaService;
import com.br.services.TradicionalService;

public class Main {

	public static void main(String[] args) {
		Mesa mesa = new Mesa();
		mesa.setNumero(5);
		MesaService.criar(mesa);
		
		Categoria categoria = new Categoria();
		categoria.setNome("Bebida");
		CategoriaService.criar(categoria);
		
		Cardapio cardapio = new Cardapio();
		cardapio.setNome("Coca");
		cardapio.setPreco(3.5f);
		cardapio.setCategoria(categoria);		
		CardapioService.criar(cardapio);
		
		Tradicional pedido = new Tradicional();
		pedido.addItemCardapio(10, cardapio);
		pedido.setMesa(mesa);
//		itemCard.setPedido(pedido);
		
		
		
		TradicionalService.criar(pedido);
		
//		Cliente cliente = new Cliente();
//		cliente.setNome("Alex");
//		cliente.setLogin("narokw");
//		cliente.setSenha("senha");
//		cliente.setDataCadastro(new Date());
//	
//		ClienteService.criar(cliente);
	
		Tradicional pedido2 = new Tradicional();
		pedido2.setId(58l);
		pedido2 = TradicionalService.procurar(pedido2);
		System.out.println(pedido2); 
	}

}
