package com.br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.br.entity.Cliente;
import com.br.exception.LoginExistenteException;

public class ClienteDaO {
	
	EntityManagerFactory factory = null;
	EntityManager em = null;
	
	public ClienteDaO(){
		factory = Persistence.createEntityManagerFactory("projeto");
		em = factory.createEntityManager();
	}
	
	public void inserirCliente(Cliente cliente){
		
		if(!isCliente(cliente.getLogin())){
			em.persist(cliente);
			em.getTransaction().begin();
			em.getTransaction().commit();
		}	
		throw new LoginExistenteException("Login já cadastrado");		
	}

	public Cliente buscarClientePorIdEager(long id){		 
		return em.find(Cliente.class, id);
	}
	public Cliente buscarClientePorIdLazy(long id){		 
		return em.getReference(Cliente.class, id);
	}
	
	public boolean isCliente(String login){
		String consulta = "SELECT c FROM Cliente c WHERE c.login= :login";
		Query query = em.createQuery(consulta);
		query.setParameter("login", login);
		query.setMaxResults(1);
		
		try{
			@SuppressWarnings("unused")
			Object cliente = query.getSingleResult();
	
		} catch (NoResultException e){
					return false;
		}
		return true;
	}
	
	public Cliente getLogar(String login,String senha){
		String consulta = "SELECT c FROM Cliente c WHERE c.login= :login AND c.senha= :senha";
		Query query = em.createQuery(consulta);
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		query.setMaxResults(1);
		Object cliente = query.getSingleResult();
		
		if(cliente!=null){
			return (Cliente)cliente;
		}
		return null;
	}
	public boolean update(Cliente cliente) {
		Cliente cliDb = em.find(Cliente.class, cliente.getId());
		if(cliDb!=null){
			em.getTransaction().begin();
			em.getTransaction().commit();
			return true;
		}
		return false;
	}

	public List<Cliente> list() {
		Query query = em.createQuery("SELECT c FROM Cliente c");
		@SuppressWarnings("unchecked")
		List<Cliente> clientes = query.getResultList();
		return clientes;
	}
}
