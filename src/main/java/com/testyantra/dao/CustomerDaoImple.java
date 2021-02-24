package com.testyantra.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.testyantra.customerdto.Customers;
import com.testyantra.utility.EntityManagerUtility;

public class CustomerDaoImple implements CustomerDao{

	Scanner sc = new Scanner(System.in);
	List<Customers> list = new ArrayList<>();
	EntityManager entityManager = null;
	
	public void addCustomer(Customers customer) {
		try {
		
		entityManager = EntityManagerUtility.dbConnector();
		entityManager.getTransaction().begin();
		entityManager.persist(customer);
		
		entityManager.getTransaction().commit();
		
		System.out.println("Customer Record Added");
		
		EntityManagerUtility.closeResources();
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	public void fetchAllCustomers() {
		try {
			entityManager = EntityManagerUtility.dbConnector();
			entityManager.getTransaction().begin();
			
			Query query = entityManager.createQuery("from Customers");
			
		    @SuppressWarnings("unchecked")
			List<Customers> list = query.getResultList();
		    
	    	for(Customers cust : list) {
		   		 System.out.println(cust);
		   	}
	    	
	    	EntityManagerUtility.closeResources();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	public boolean deleteCustomer(int customerId,Customers customer) {
		try {
			
			entityManager = EntityManagerUtility.dbConnector();
			entityManager.getTransaction().begin();
			
			customer = entityManager.getReference(Customers.class, customerId);
	    	entityManager.remove(customer);
	    	
	    	entityManager.getTransaction().commit();
	    	
	    	System.out.println("Record Deleted");
	    	
	    	EntityManagerUtility.closeResources();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public void updateCustomer(int id,String name,Customers customer) {
		try {
			entityManager = EntityManagerUtility.dbConnector();
			entityManager.getTransaction().begin();
			
			customer.setCustomerId(id);
			customer.setCustomerName(name);
			entityManager.merge(customer);
	    	
	    	entityManager.getTransaction().commit();
	    	
	    	System.out.println("Customer name updated");
	    	
	    	EntityManagerUtility.closeResources();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	public void fetchByName(String names) {
		try {
			entityManager = EntityManagerUtility.dbConnector();
			entityManager.getTransaction().begin();
			
			//c.dtoVarName=:placeholder
			Query query = entityManager.createQuery("from Customers C where C.customerName=:names");
			query.setParameter("names", names); 
			
		    @SuppressWarnings("unchecked")
			List<Customers> list = query.getResultList();
		    
	    	for(Customers cust : list) {
		   		 System.out.println(cust);
		   	}
	    	
	    	EntityManagerUtility.closeResources();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void getName(String typedName) {
		try {
			entityManager = EntityManagerUtility.dbConnector();
			entityManager.getTransaction().begin();
			
			//c.dtoVarName=:placeholder
			//go for typed query when you know type of parameters and want compile-time checking
			//no select * in hql query, select * is replaced by select varName
			TypedQuery<Customers> type = entityManager.createQuery("select C from Customers C where C.customerName=:names",Customers.class);
			
			type.setParameter("names", typedName); 
			
			Customers name =type.getSingleResult();
			System.out.println(name);
		   
			EntityManagerUtility.closeResources();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	@Override
	public void getNameByNamedQuery(String name) {
		try {
			entityManager = EntityManagerUtility.dbConnector();
			entityManager.getTransaction().begin();
			
			//c.dtoVarName=:placeholder
			Query namedQuery = entityManager.createNamedQuery("Customers.findByUserId");
			namedQuery.setParameter("name", name);
			
			Customers cust = (Customers) namedQuery.getSingleResult();
			System.out.println(cust);
		   
			EntityManagerUtility.closeResources();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
