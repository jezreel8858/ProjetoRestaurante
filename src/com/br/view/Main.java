package com.br.view;

import java.util.ArrayList;
import java.util.Date;

import com.br.model.Cardapio;
import com.br.model.ItemCardapio;
import com.br.model.Pedido;
import com.br.services.CardapioService;
import com.br.services.PedidoService;

public class Main {

	public static void main(String[] args) {

	Pedido pedido = new Pedido();
	ItemCardapio itemCard = new ItemCardapio();
	Cardapio cardapio = new Cardapio();

	
		
	pedido.setData(new Date());
	pedido.setStatus("Pendente");
	
	cardapio.setId(1L);
	
	ArrayList<ItemCardapio> itensCardapio = new ArrayList<ItemCardapio>();
	
	//cardapio = CardapioService.find(cardapio);
	itemCard.setCardapio(cardapio);
	itemCard.setQuantidade(10);
	itensCardapio.add(itemCard);
	pedido.setItemCardapios(itensCardapio);
	
	PedidoService.insert(pedido);
	
	
	
	}

}
