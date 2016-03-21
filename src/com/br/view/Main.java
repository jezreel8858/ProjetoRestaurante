package com.br.view;

import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.br.model.Cliente;
import com.br.services.ClienteService;
import com.br.services.DeliveryService;
import com.br.services.TradicionalService;

public class Main {

	public static void main(String[] args) throws ParseException {
//		Mesa mesa = new Mesa();
//		mesa.setNumero(5);
//		MesaService.criar(mesa);
//		
//		Categoria categoria = new Categoria();
//		categoria.setNome("Bebida");
//		CategoriaService.criar(categoria);
//		
//		Cardapio cardapio = new Cardapio();
//		cardapio.setNome("Coca");
//		cardapio.setPreco(3.5f);
//		cardapio.setCategoria(categoria);		
//		CardapioService.criar(cardapio);
//		
//		Tradicional pedido = new Tradicional();
//		pedido.addItemCardapio(10, cardapio);
//		pedido.setMesa(mesa);
//		itemCard.setPedido(pedido);
		
		
		
//		TradicionalService.criar(pedido);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Alex");
		try {
			cliente.createLogin("Narok2", "123");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cliente.setDataCadastro(new Date());
	
		ClienteService.criar(cliente);
	
//		Tradicional pedido2 = new Tradicional();
//		pedido2.setId(2L);
//		DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
//		Date dataI = (Date)formatter.parse("01/01/2016");
//		Date dataF = (Date)formatter.parse("01/02/2016");
//		Object lista = DeliveryService.relatorioPorIntervaloData(dataI, dataF);
		//ValorTotal tra =  lista.;
//		System.out.println(lista); 
	}

}
