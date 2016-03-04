package com.br.view;

import javax.persistence.EntityManager;

import com.br.dao.ClienteDAO;
import com.br.model.Cliente;
import com.br.model.Endereco;
import com.br.util.JPAUtil;

public class Main {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		endereco.setCep("58077-028");
		endereco.setCidade("João Pessoa");
		endereco.setComplemento("Apart");
		endereco.setEstado("Paraiba");
		endereco.setLogradouro("desem");
		endereco.setNumero("167b");
		endereco.setPais("Brasil");	
		cliente.setNome("Jezreel");
		cliente.setEmail("pedroNeto@gmail.com");
		cliente.setLogin("pedro123");
		cliente.setSenha("99322775");
		cliente.setTelefone("88456213");
		cliente.setEndereco(endereco);
		
		
		ClienteDAO cliDAO = new ClienteDAO(em);
		
		cliDAO.insert(cliente);
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
//		
//		
//		cliente.setNome("Jezreel");
//		cliente.setDataCadastro(new Date( System.currentTimeMillis() ));
//		@SuppressWarnings("deprecation")
//		Date data = new Date(2,8,1991);
//		cliente.setDataNasc(data);
//		cliente.setEmail("pedroNeto@gmail.com");
//		cliente.setLogin("pedro123");
//		cliente.setSenha("99322775");
//		cliente.setTelefone("88456213");
//		
//		ClienteController cli_Control = new ClienteController();
//		
////		cli_Control.cadastrarCliente(cliente);
////		Cliente cli = cli_Control.buscar(1L);
////		cli.getEndereco().setComplemento("Apartamento");
////		cli_Control.atualizar(cli);
//		
//		
//		
//		Pedido pedido = new Pedido();
//		pedido.setData(new Date( System.currentTimeMillis() ));
//		pedido.setStatus("coisa");
//		
//		em.persist(pedido);
//		em.getTransaction().begin();
//		em.getTransaction().commit();
//		
//		System.out.println(cli_Control.listaClientes());
	}

}
