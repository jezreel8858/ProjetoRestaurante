package com.br.services;

import javax.persistence.EntityManager;

import com.br.dao.CardapioDAO;
import com.br.model.Cardapio;
import com.br.util.JPAUtil;

public class CardapioService {

	public  static void insert(Cardapio cardapio) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			CardapioDAO CardapioDAO = new CardapioDAO(manager);
	
			CardapioDAO.insert(cardapio);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}
	
public  static Cardapio find(Cardapio cardapio) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Cardapio result = null;
		try{
			CardapioDAO cardapioDAO = new CardapioDAO(manager);
			
			result = cardapioDAO.findById(cardapio.getId());
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
