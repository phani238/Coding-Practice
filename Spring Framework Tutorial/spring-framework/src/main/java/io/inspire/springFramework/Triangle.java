package io.inspire.springFramework;

import java.util.List;

public class Triangle {

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

	public void draw() {
		 System.out.println("PointA=" + getPointA().getX() + ", PointB=" +
		 getPointB().getX() + " & PointC=" + getPointC().getX());
//		for (Point p : points) {
//			System.out.println("Point X=" + p.getX() + " & Y=" + p.getY());
//		}
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
}
