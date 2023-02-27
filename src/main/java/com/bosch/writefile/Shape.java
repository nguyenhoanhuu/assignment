package com.bosch.writefile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Shape {

	private String name;
	private String kind;
	private double area;

	public abstract double calculateArea();

	public Shape(String name, String kind, double area) {
		super();
		this.name = name;
		this.kind = kind;
		this.area = area;
	}

	public Shape() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Shape [name=" + name + ", kind=" + kind + ", area=" + area + "]";
	}

}
