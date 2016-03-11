package com.br.services;

import javax.persistence.EntityManager;

import com.br.dao.ReservaDAO;
import com.br.model.Reserva;
import com.br.util.JPAUtil;

public class ReservaService {

	public  static void insert(Reserva reserva) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			ReservaDAO reservaDAO = new ReservaDAO(manager);
			
			if(reserva.getMesa() == null || reserva.getFuncionario() == null){
				throw new Exception("Reserva sem mesa ou funcionario responsavel");
			}
			
			reservaDAO.insert(reserva);
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
	
	public  static void delete(Reserva reserva) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			ReservaDAO reservaDAO = new ReservaDAO(manager);
			
			reservaDAO.delete(reserva);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}
	
public  static Reserva find(Reserva reserva) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Reserva result = null;
		try{
			ReservaDAO reservaDAO = new ReservaDAO(manager);
			
			result = reservaDAO.findById(reserva.getId());
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
