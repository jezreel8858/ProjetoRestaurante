package com.br.services;

import javax.persistence.EntityManager;

import com.br.dao.CategoriaDAO;
import com.br.model.Categoria;
import com.br.util.JPAUtil;

public class CategoriaService {

	public  static void insert(Categoria categoria) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
			
			categoriaDAO.insert(categoria);
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
	
	public  static void delete(Categoria categoria) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
			
			categoriaDAO.delete(categoria);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}
	
public  static Categoria find(Categoria categoria) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Categoria result = null;
		try{
			CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
			
			result = categoriaDAO.findById(categoria.getId());
			
		}catch (Exception e){

		}
		finally{
			manager.close();
		}
		return result;
	}
}
