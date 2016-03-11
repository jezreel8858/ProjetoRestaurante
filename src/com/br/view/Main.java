package com.br.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.br.model.Cardapio;
import com.br.model.Cliente;
import com.br.model.ItemCardapio;
import com.br.model.Pedido;
import com.br.services.CardapioService;
import com.br.services.ClienteService;
import com.br.services.PedidoService;

public class Main {

	public static void main(String[] args) {

	Pedido pedido = new Pedido();
	ItemCardapio itemCard = new ItemCardapio();
	Cardapio cardapio = new Cardapio();
	cardapio.setNome("Coca");
	cardapio.setPreco(3.5f);

	itemCard.setQtd(10);
	itemCard.setCardapio(cardapio);
	List<ItemCardapio> itemCardapios = new ArrayList<>();
	
	itemCardapios.add(itemCard);
	
	pedido.setItemCardapios(itemCardapios);
	
	CardapioService.insert(cardapio);
	PedidoService.insert(pedido);
	
	Cliente cliente = new Cliente();
	cliente.setNome("Alex");
	cliente.setLogin("narokw");
	cliente.setSenha("senha");
	cliente.setDataCadastro(new Date());

	ClienteService.insert(cliente);
	
	
	}

}
