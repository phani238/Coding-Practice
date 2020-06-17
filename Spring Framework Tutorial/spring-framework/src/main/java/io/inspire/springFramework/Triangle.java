package io.inspire.springFramework;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements Shape, ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean {

	public Triangle() {
	}

	public Triangle(String type) {
		this.type = type;
	}

	public Triangle(int height) {
		this.height = height;
	}

	public Triangle(String type, int height) {
		this.type = type;
		this.height = height;
	}

	private String type;
	private int height;

	private Point pointA;
	private Point pointB;
	private Point pointC;

	private List<Point> points;

	@SuppressWarnings("unused")
	private ApplicationContext context = null;

	public void draw() {
		System.out.println("Drawing Triangle");
		System.out.println(
				"PointA=" + getPointA().getX() + ", PointB=" + getPointB().getX() + " & PointC=" + getPointC().getX());
		// for (Point p : points) {
		// System.out.println("Point X=" + p.getX() + " & Y=" + p.getY());
		// }
	}

	public String getType() {
		return type;
	}

	public int getHeight() {
		return height;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	public void setBeanName(String beanName) {
		System.out.println("Bean Name is: " + beanName);
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("This is InitiazingBean using super class");
	}

	public void destroy() throws Exception {
		System.out.println("Bean is Destroyed using super class");
	}

	public void myInit() {
		System.out.println("This is InitiazingBean using default spring.xml");
	}

	public void cleanUp() {
		System.out.println("Bean is Destroyed using default spring.xml");
	}
}
