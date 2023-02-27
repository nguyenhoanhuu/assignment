package com.bosch.writefile;

public class Square extends Shape {

	private double side;

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public Square(String name, String kind, double area, double side) {
		super(name, kind, area);
		this.side = side;
	}

	public Square(String name, String kind, double area) {
		super(name, kind, area);
	}

	@Override
	public double calculateArea() {
		return Math.pow(this.side, 2);
	}

}