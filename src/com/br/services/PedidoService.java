package com.br.services;

import javax.persistence.EntityManager;

import com.br.dao.ItemCardapioDAO;
import com.br.dao.PedidoDAO;
import com.br.model.ItemCardapio;
import com.br.model.Pedido;
import com.br.util.JPAUtil;

public class PedidoService {

	public  static void insert(Pedido pedido) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			PedidoDAO pedidoDAO = new PedidoDAO(manager);
			ItemCardapioDAO ItemCardapioDAO = new ItemCardapioDAO(manager);
			
			for(ItemCardapio itemCardapio:pedido.getItemCardapios()){
				if(itemCardapio.getCardapio() == null ){
					throw new Exception("Item sem cardápio");
				}
				ItemCardapioDAO.insert(itemCardapio);
			}
			pedidoDAO.insert(pedido);
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
	
	public  static void update(Pedido pedido) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			PedidoDAO pedidoDAO = new PedidoDAO(manager);
			ItemCardapioDAO ItemCardapioDAO = new ItemCardapioDAO(manager);
			
			for(ItemCardapio itemCardapio:pedido.getItemCardapios()){
				if(itemCardapio.getCardapio() == null ){
					throw new Exception("Item sem cardápio");
				}
				ItemCardapioDAO.update(itemCardapio);
			}
			pedidoDAO.update(pedido);
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
	
	public  static void delete(Pedido pedido) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			PedidoDAO pedidoDAO = new PedidoDAO(manager);
			ItemCardapioDAO ItemCardapioDAO = new ItemCardapioDAO(manager);
			
			for(ItemCardapio ItemCardapio:pedido.getItemCardapios()){
				ItemCardapioDAO.delete(ItemCardapio);
			}
			pedidoDAO.delete(pedido);
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
	
	public  static Pedido find(Pedido pedido) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Pedido result = null;
		try{
			PedidoDAO pedidoDAO = new PedidoDAO(manager);
			
			result = pedidoDAO.findById(pedido.getId());
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			if(manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
		return result;
	}

}
