package com.testyantra.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtility {

	static EntityManagerFactory entityManagerFactory;
	static EntityManager entityManager;
	public static EntityManager dbConnector(){
		//step 1
    	entityManagerFactory = Persistence.createEntityManagerFactory("CustomersDB");
    	
    	//step 2
    	entityManager = entityManagerFactory.createEntityManager();
    	
    	
    	return entityManager;
	}
	
	public static void closeResources() {
		//last step
		entityManager.close();
		entityManagerFactory.close();
	}
	
}
