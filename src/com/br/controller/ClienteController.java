package com.br.controller;



import java.util.List;

import com.br.dao.ClienteDaO;
import com.br.entity.Cliente;

public class ClienteController {

	private ClienteDaO clienteDao = null;
	
	public ClienteController(){
		clienteDao = new ClienteDaO();
	}
	
	public void cadastrarCliente(Cliente cliente){
			clienteDao.inserirCliente(cliente);
	}
	
	public Cliente buscarCliente(long id){
		return clienteDao.buscarClientePorIdEager(id);
	}
	
	public Cliente logarCliente(String login,String senha){
		return clienteDao.getLogar(login, senha);		
	}
	
	public boolean atualizarCliente(Cliente cliente){
		return clienteDao.update(cliente);
	}
	public List<Cliente> listaClientes(){
		return clienteDao.list();
	}
}
