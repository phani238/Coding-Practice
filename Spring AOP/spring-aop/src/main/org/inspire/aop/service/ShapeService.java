package org.inspire.aop.service;

import org.inspire.aop.aspect.Loggable;
import org.inspire.aop.model.Circle;
import org.inspire.aop.model.Triangle;

public class ShapeService {

	private Circle circle;
	private Triangle triangle;

	@Loggable
	public Circle getCircle() {
//		int i =0;
//		int j =1;
//		System.out.println(j/i);
		System.out.println("Circle getter called");
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public Triangle getTriangle() {
		return triangle;
	}

	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
}
