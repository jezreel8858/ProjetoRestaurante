package com.br.services;

import javax.persistence.EntityManager;

import com.br.dao.MesaDAO;
import com.br.model.Mesa;
import com.br.util.JPAUtil;

public class MesaService {

	public  static void insert(Mesa mesa) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			MesaDAO mesaDAO = new MesaDAO(manager);
			
			mesaDAO.insert(mesa);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}
	
	public  static void delete(Mesa mesa) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			MesaDAO mesaDAO = new MesaDAO(manager);
			
			mesaDAO.delete(mesa);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}
	
public  static Mesa find(Mesa mesa) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Mesa result = null;
		try{
			MesaDAO mesaDAO = new MesaDAO(manager);
			
			result = mesaDAO.findById(mesa.getId());
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
