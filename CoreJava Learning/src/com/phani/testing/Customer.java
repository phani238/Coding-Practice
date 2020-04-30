package com.phani.testing;


 class Customer {

	String name;
	static int numOfCustomer= 0 ;
	
	public void setCustomerName(String newName)
	{
		name = newName;
		numOfCustomer++;
	}
}
