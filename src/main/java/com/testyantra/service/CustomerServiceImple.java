package com.testyantra.service;


import java.util.Scanner;

import com.testyantra.customerdto.Customers;
import com.testyantra.dao.CustomerDao;
import com.testyantra.dao.CustomerDaoImple;

public class CustomerServiceImple implements CustomerService {

	CustomerDao customers = new CustomerDaoImple();
	Customers customer = new Customers();
	Scanner sc = new Scanner(System.in);
	
	public void addCustomer() {
		System.out.println("Enter Customer Id");
		int custId = sc.nextInt();
		System.out.println("Enter Customer Name");
		String custName = sc.next();
		customer = new Customers(custId, custName);
		 customers.addCustomer(customer);
	}

	public void fetchAllCustomers() {
		 customers.fetchAllCustomers();
	}

	public void deleteCustomer(Customers customer) {
		System.out.println("Enter Customer Id to be deleted");
		int customerId = sc.nextInt();
		 customers.deleteCustomer(customerId,customer);
	}

	public void updateCustomer(Customers customer) {
		System.out.println("Enter Customer Id to update");
	 	 int id = sc.nextInt();
	 	 System.out.println("Enter new Name");
	 	 String name = sc.next();
		 customers.updateCustomer(id,name,customer);
	}

	public void fetchByName() {
		System.out.println("Enter name to fetch details");
		String name = sc.next();
		customers.fetchByName(name);
	}

	public void getName() {
		System.out.println("Enter name to fetch by typed query");
		String typedName = sc.next();
		customers.getName(typedName);
	}

	public void getNameByNamedQuery() {
		System.out.println("Enter name to fetch by typed query");
		String namedQuery = sc.next();
		customers.getNameByNamedQuery(namedQuery);
	}

}
