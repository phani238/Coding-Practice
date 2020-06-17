package io.inspire.springFramework;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
//		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		context.registerShutdownHook();
//		Shape s = (Shape) context.getBean("triangle3");
		Shape s = (Shape) context.getBean("circle");
		s.draw();
//		Triangle t = (Triangle) context.getBean("triangle3");
//		t.draw();
//		Circle c = (Circle) context.getBean("circle");
//		c.draw();
		
		System.out.println("From Parent: " +context.getMessage("greeting", null, "Default Greeting", null));
	}

}
