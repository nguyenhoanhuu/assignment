package writteFileCode;

class Circle extends Shape {
	private String name;
	private double radius;

	public Circle(String name, double radius) {
		this.name = name;
		this.radius = radius;
	}

	public double calculateArea() {
		return Math.PI * radius * radius;
	}

	public String toString() {
		return String.format("My name is \"%s\". I’m a circle. My area is %.1f.", name, calculateArea());
	}
}