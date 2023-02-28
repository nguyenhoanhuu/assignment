package writteFileCode;

class Square extends Shape {
	private String name;
	private double side;

	public Square(String name, double side) {
		this.name = name;
		this.side = side;
	}

	public double calculateArea() {
		return side * side;
	}

	public String toString() {
		return String.format("My name is \"%s\". I’m a square. My area is %.1f.", name, calculateArea());
	}
}
