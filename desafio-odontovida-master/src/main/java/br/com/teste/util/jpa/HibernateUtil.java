package br.com.teste.util.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static EntityManagerFactory entitymanagerfactory;
	
	private HibernateUtil (){};
	public static EntityManagerFactory getEntityManagerFactory() {
		if (entitymanagerfactory == null) {
			try {
				entitymanagerfactory = Persistence.createEntityManagerFactory("Connection-PU");
			} catch (Exception exception) {
				System.err.println("falhou" + exception);
			}
		}
		return entitymanagerfactory;
	}
}
