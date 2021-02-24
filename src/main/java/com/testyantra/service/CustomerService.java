package com.testyantra.service;


import com.testyantra.customerdto.Customers;

public interface CustomerService {
	public void addCustomer();
	public void fetchAllCustomers();
	public void deleteCustomer(Customers customer);
	public void updateCustomer(Customers customer);
	public void fetchByName();
	public void getName();
	public void getNameByNamedQuery();
}
