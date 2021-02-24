package com.testyantra.HibernateCustomers;

import java.util.Scanner;


import com.testyantra.customerdto.Customers;
import com.testyantra.service.CustomerServiceImple;

public class App 
{
    public static void main( String[] args )
    {

    	Scanner sc = new Scanner(System.in);
    	CustomerServiceImple imple = new CustomerServiceImple();
    	Customers customer = new Customers();
    	System.out.println("========Welcome to Customers App========");
    	
    	while(true) {
    		System.out.println("What would you like to do?");
    		System.out.println("1.Add Customer \n2.Update Customer \n3.Delete Customer \n4.Fetch all Customers \n5.Fetch By Name \n6.Get name by Typed Query \n7.Get Name by Named Query \n8.Exit");
    		int choice = sc.nextInt();
    		
    		switch(choice) {
    			case 1 : imple.addCustomer();
    					 break;
    					 
    			case 2 : imple.updateCustomer(customer);
    			 	 	 break;
    			 	 	 
    			case 3 : imple.deleteCustomer(customer);
    					 break;
    					 
    			case 4 : imple.fetchAllCustomers();
    			 		 break;
    			 		 
    			case 5 : imple.fetchByName();
    					 break;
    			 		 
    			case 6 : imple.getName();
    					 break;
    					
    			case 7 : imple.getNameByNamedQuery();
    					 break;
    					 
    			case 8 : System.exit(0);
    			 		 
    			
    			default : System.out.println("Invalid Choice...Try Again");
    					 
    					 
    		}
    		
    	}
  
    }
}
