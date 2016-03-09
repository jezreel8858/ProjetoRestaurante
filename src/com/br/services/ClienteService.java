package com.br.services;

import javax.persistence.EntityManager;

import com.br.dao.ClienteDAO;
import com.br.model.Cliente;
import com.br.util.JPAUtil;

public class ClienteService {

	public  static void insert(Cliente cliente) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			ClienteDAO clienteDAO = new ClienteDAO(manager);
			Cliente teste = clienteDAO.getClienteLogin(cliente);
			if(teste!=null){
				clienteDAO.insert(cliente);
				manager.getTransaction().begin();
				manager.getTransaction().commit();
			}
			
			
		}catch (Exception e){
			System.out.println(e.getMessage());
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}
	
	public  static void delete(Cliente cliente) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			ClienteDAO clienteDAO = new ClienteDAO(manager);
			
			clienteDAO.delete(cliente);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}
	
public  static Cliente find(Cliente cliente) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Cliente result = null;
		try{
			ClienteDAO clienteDAO = new ClienteDAO(manager);
			
			result = clienteDAO.findById(cliente.getId());
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
		return result;
	}
}
