package com.br.services;

import javax.persistence.EntityManager;

import com.br.dao.FuncionarioDAO;
import com.br.model.Funcionario;
import com.br.util.JPAUtil;

public class FuncionarioService {

	public  static void insert(Funcionario funcionario) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO(manager);
			boolean exist = funcionarioDAO.exist(funcionario);
			if(exist){
				throw new Exception("Funcionario já existe");
			}
				
			funcionarioDAO.insert(funcionario);
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
	
	public static void update(Funcionario funcionario){
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO(manager);
			funcionarioDAO.update(funcionario);
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
	
	public static void delete(Funcionario funcionario) {
		funcionario.setAtivo(false);
		update(funcionario);
	}
	
	public  static Funcionario find(Funcionario funcionario) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Funcionario result = null;
		try{
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO(manager);
			
			result = funcionarioDAO.findById(funcionario.getId());
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
