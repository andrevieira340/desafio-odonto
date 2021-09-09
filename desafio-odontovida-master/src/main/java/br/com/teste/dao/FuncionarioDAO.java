package br.com.teste.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.teste.entity.Funcionario;
import br.com.teste.util.jpa.Transactional;

public class FuncionarioDAO {
	
	
	/* aqui cria a queria para atualizar */
	@PersistenceContext
    private EntityManager manager;

	@Transactional
	public Funcionario Save_Update(Funcionario funcionario) {
		EntityManager entitymanager = br.com.teste.util.jpa.HibernateUtil.getEntityManagerFactory().createEntityManager();
		try {
			entitymanager.getTransaction().begin();
			entitymanager.getTransaction().commit();
			
	} catch (Exception exception) {
		entitymanager.getTransaction().rollback();
		}
		return funcionario;
	}
	
	
	
	
	public void Delete_dados(Funcionario funcionario) {
		EntityManager entitymanager = br.com.teste.util.jpa.HibernateUtil.getEntityManagerFactory().createEntityManager();
		try {
			entitymanager.getTransaction().begin();
			Funcionario funcionario_ = entitymanager.find(Funcionario.class, funcionario.getId());
			entitymanager.remove(funcionario_);
			entitymanager.getTransaction().commit();
		} catch (Exception exception) {
			entitymanager.getTransaction().rollback();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> list() {
		List <Funcionario> resultado = null;
		try {
			EntityManager entitymanager = br.com.teste.util.jpa.HibernateUtil.getEntityManagerFactory().createEntityManager();
			Query query = entitymanager.createNativeQuery("SELECT * FROM Funcionario "); // devido ao orm ser 5.2.4 tive que usar o comando
			                                                                             // "select * from funcionario" para listar
					
			resultado = query.getResultList();
		} catch (Exception exception) {
			exception.printStackTrace();
		
		}
		return resultado;
	}
	
	

}
