package com.bosch.writefile;

public class Circle extends Shape {

	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Circle(String name, String kind, double area, double radius) {
		super(name, kind, area);
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		return Math.PI * this.radius * this.radius;
	}

}
