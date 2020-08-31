package org.inspire.aop.service;

import org.inspire.aop.model.Circle;
import org.inspire.aop.model.Triangle;

public class FactoryService {

	public Object getBean(String beanType) {
		if(beanType.equals("shapeService")) return new ShapeServiceProxy();
		if(beanType.equals("circle")) return new Circle();
		if(beanType.equals("triangle")) return new Triangle();
		return null;
	}
}
