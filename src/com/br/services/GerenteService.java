package com.br.services;

import javax.persistence.EntityManager;

import com.br.dao.GerenteDAO;
import com.br.model.Gerente;
import com.br.util.JPAUtil;

public class GerenteService {

	public  static void insert(Gerente gerente) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			GerenteDAO gerenteDAO = new GerenteDAO(manager);
			boolean exist = gerenteDAO.exist(gerente);
			if(exist){
				throw new Exception("Usuario já existe");
			}
				
			gerenteDAO.insert(gerente);
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
	
	public static void update(Gerente gerente){
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			GerenteDAO gerenteDAO = new GerenteDAO(manager);
			gerenteDAO.update(gerente);
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
	
	public static void delete(Gerente gerente) {
		gerente.setAtivo(false);
		update(gerente);
	}
	
	public  static Gerente find(Gerente gerente) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Gerente result = null;
		try{
			GerenteDAO gerenteDAO = new GerenteDAO(manager);			
			result = gerenteDAO.findById(gerente.getId());	
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}
}
