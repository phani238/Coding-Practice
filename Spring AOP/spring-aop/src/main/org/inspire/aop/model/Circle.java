package org.inspire.aop.model;

public class Circle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle's setter called");
//		int i =0;
//		int j =1;
//		System.out.println(j/i);
		throw(new RuntimeException());
	}
	
	public String setNameAndReturn(String name) {
		this.name = name;
		System.out.println("Circle's setter called");
		return "TestAfterReturnAspect";
	}
}
