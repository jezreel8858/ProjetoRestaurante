package com.br.services;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.br.dao.DeliveryDAO;
import com.br.dao.ItemCardapioDAO;
import com.br.model.Delivery;
import com.br.model.ItemCardapio;
import com.br.util.JPAUtil;

public class DeliveryService {

	public  static void criar(Delivery delivery) {
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
	
	public  static void atualizar(Delivery delivery) {
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
	
	public  static void remover(Delivery delivery) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			DeliveryDAO deliveryDAO = new DeliveryDAO(manager);
			ItemCardapioDAO ItemCardapioDAO = new ItemCardapioDAO(manager);
			
			for(ItemCardapio ItemCardapio:delivery.getItemCardapios()){
				ItemCardapioDAO.delete(ItemCardapio);
			}
			
			deliveryDAO.delete(delivery);
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
	
	public  static Delivery procurar(Delivery delivery) {
		
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
	
	public static List<Delivery> listar(){
		EntityManager  manager =  JPAUtil.getEntityManager();
		List<Delivery> result = Collections.emptyList();
		try{
			DeliveryDAO deliveryDAO = new DeliveryDAO(manager);
			result = deliveryDAO.getAll();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Object[]> relatorioPorIntervaloData(Date dataI,Date dataF){
		EntityManager  manager =  JPAUtil.getEntityManager();
		Query result = null;
		List<Object[]> lista = null;
		try{
			result = manager.createQuery("SELECT d.cliente.nome,d.data,SUM(i.qtd * i.cardapio.preco) FROM Delivery d inner join d.itensCardapio i"
										+ " where d.status = 'Atendido' and d.data between :dataI and :dataF  group by d.cliente.nome,d.data");
			result.setParameter("dataI", dataI);
			result.setParameter("dataF", dataF);
			lista =  result.getResultList();
			for (Object[] object : lista) {
				for (Object object2 : object) {
					System.out.println(object2);
				}
			}
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return lista;
	}

}
