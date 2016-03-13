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
			boolean exist = clienteDAO.exist(cliente);
			if(exist){
				throw new Exception("Usuario já existe");
			}
				
			clienteDAO.insert(cliente);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
			if(manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}
	
	public static void update(Cliente cliente){
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			ClienteDAO clienteDAO = new ClienteDAO(manager);
			clienteDAO.update(cliente);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			if(manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}
	
	public static void delete(Cliente cliente) {
		cliente.setAtivo(false);
		update(cliente);
	}
	
	public  static Cliente find(Cliente cliente) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Cliente result = null;
		try{
			ClienteDAO clienteDAO = new ClienteDAO(manager);
			
			result = clienteDAO.findById(cliente.getId());

			
		}catch (Exception e){

		}
		finally{
			manager.close();
		}
		return result;
	}
}
