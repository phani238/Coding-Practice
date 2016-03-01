package com.phani.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void test() {
		Customer customer = new Customer();
		customer.setCustomerName("chandra");
		assertEquals("chandra", customer.name);
		assertEquals(1, Customer.numOfCustomer);

		Customer customer1 = new Customer();
		customer1.setCustomerName("phani");
		assertEquals("chandra", customer.name);
		assertEquals("phani", customer1.name);
		assertEquals(2, Customer.numOfCustomer);
	}
}