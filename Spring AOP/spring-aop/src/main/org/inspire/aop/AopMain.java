package org.inspire.aop;

import org.inspire.aop.service.FactoryService;
import org.inspire.aop.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//		ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
//		shapeService.getCircle();
//		shapeService.getCircle().setName("Dummy Name");
//		shapeService.getCircle().setNameAndReturn("Dummy Name");
//		System.out.println(shapeService.getCircle().getName());
		
		FactoryService fs = new FactoryService();
		ShapeService shapeService = (ShapeService) fs.getBean("shapeService");
		shapeService.getCircle();
	}

}
