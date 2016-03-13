package com.br.view;

import java.util.ArrayList;
import java.util.List;

import com.br.model.Cardapio;
import com.br.model.Categoria;
import com.br.model.ItemCardapio;
import com.br.model.Pedido;
import com.br.services.CardapioService;
import com.br.services.CategoriaService;
import com.br.services.PedidoService;

public class Main {

	public static void main(String[] args) {
		
		Categoria categoria = new Categoria();
		categoria.setNome("Bebida");
		CategoriaService.insert(categoria);
		
		Cardapio cardapio = new Cardapio();
		cardapio.setNome("Coca");
		cardapio.setPreco(3.5f);
		cardapio.setCategoria(categoria);		
		CardapioService.insert(cardapio);
		
		Pedido pedido = new Pedido();
		pedido.addItemCardapio(10, cardapio);
//		itemCard.setPedido(pedido);
		
		
		
		PedidoService.insert(pedido);
		
//		Cliente cliente = new Cliente();
//		cliente.setNome("Alex");
//		cliente.setLogin("narokw");
//		cliente.setSenha("senha");
//		cliente.setDataCadastro(new Date());
//	
//		ClienteService.insert(cliente);
	
		Pedido pedido2 = new Pedido();
		pedido2.setId(21l);
		pedido2 = PedidoService.find(pedido2);
		System.out.println(pedido2);

	
	}

}
