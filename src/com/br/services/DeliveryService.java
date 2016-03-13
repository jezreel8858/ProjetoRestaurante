package com.br.services;

import javax.persistence.EntityManager;

import com.br.dao.ItemCardapioDAO;
import com.br.dao.DeliveryDAO;
import com.br.model.ItemCardapio;
import com.br.model.Delivery;
import com.br.util.JPAUtil;

public class DeliveryService {

	public  static void insert(Delivery delivery) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			DeliveryDAO deliveryDAO = new DeliveryDAO(manager);
			ItemCardapioDAO ItemCardapioDAO = new ItemCardapioDAO(manager);
			if(delivery.getCliente() == null){
				throw new Exception("Delivery sem cliente");
			}
			for(ItemCardapio itemCardapio:delivery.getItemCardapios()){
				if(itemCardapio.getCardapio() == null ){
					throw new Exception("Item sem cardápio");
				}
				ItemCardapioDAO.insert(itemCardapio);
			}
			deliveryDAO.insert(delivery);
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
	
	public  static void update(Delivery delivery) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			DeliveryDAO deliveryDAO = new DeliveryDAO(manager);
			ItemCardapioDAO ItemCardapioDAO = new ItemCardapioDAO(manager);
			
			for(ItemCardapio itemCardapio:delivery.getItemCardapios()){
				if(itemCardapio.getCardapio() == null ){
					throw new Exception("Item sem cardápio");
				}
				ItemCardapioDAO.update(itemCardapio);
			}
			deliveryDAO.update(delivery);
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
	
	public  static void delete(Delivery delivery) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			DeliveryDAO deliveryDAO = new DeliveryDAO(manager);
//			ItemCardapioDAO ItemCardapioDAO = new ItemCardapioDAO(manager);
			
//			for(ItemCardapio ItemCardapio:delivery.getItemCardapios()){
//				ItemCardapioDAO.delete(ItemCardapio);
//			}
			delivery.setStatus("Cancelado");
			deliveryDAO.update(delivery);
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
	
	public  static Delivery find(Delivery delivery) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Delivery result = null;
		try{
			DeliveryDAO deliveryDAO = new DeliveryDAO(manager);	
			result = deliveryDAO.findById(delivery.getId());
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}

}
