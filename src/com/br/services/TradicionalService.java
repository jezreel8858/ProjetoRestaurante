package com.br.services;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import com.br.dao.ItemCardapioDAO;
import com.br.dao.TradicionalDAO;
import com.br.model.ItemCardapio;
import com.br.model.Tradicional;
import com.br.util.JPAUtil;

public class TradicionalService {

	public  static void criar(Tradicional pedido) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			TradicionalDAO pedidoDAO = new TradicionalDAO(manager);
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
	
	public  static void atualizar(Tradicional pedido) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			TradicionalDAO pedidoDAO = new TradicionalDAO(manager);
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
	
	public  static void remover(Tradicional pedido) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			TradicionalDAO pedidoDAO = new TradicionalDAO(manager);
//			ItemCardapioDAO ItemCardapioDAO = new ItemCardapioDAO(manager);
			
//			for(ItemCardapio ItemCardapio:pedido.getItemCardapios()){
//				ItemCardapioDAO.delete(ItemCardapio);
//			}
			pedido.setStatus("Cancelado");
			pedidoDAO.update(pedido);
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
	
	public  static Tradicional procurar(Tradicional pedido) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Tradicional result = null;
		try{
			TradicionalDAO pedidoDAO = new TradicionalDAO(manager);	
			result = pedidoDAO.findById(pedido.getId());
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}
	
	public static List<Tradicional> listar(){
		EntityManager  manager =  JPAUtil.getEntityManager();
		List<Tradicional> result = Collections.emptyList();
		try{
			TradicionalDAO tradicionalDAO = new TradicionalDAO(manager);
			result = tradicionalDAO.getAll();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}

}
