package com.testyantra.dao;


import com.testyantra.customerdto.Customers;

public interface CustomerDao {
	public void addCustomer(Customers customer);
	public void fetchAllCustomers();
	public boolean deleteCustomer(int customerId, Customers customer);
	public void updateCustomer(int id,String name,Customers customer);
	public void fetchByName(String name);
	public void getName(String typedName);
	public void getNameByNamedQuery(String name);
}
