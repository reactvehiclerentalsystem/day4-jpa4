package com.capgemini.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
	private static EntityManager manager = factory.createEntityManager();
	
	public static EntityManager getEntityManager() {
		return manager;
	}
}
