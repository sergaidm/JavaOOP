package ru.yandex.sergaidm;

public class Triangle extends Shape {

	private Point a;
	private Point b;
	private Point c;

	public Triangle(Point a, Point b, Point c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Triangle() {
		super();

	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}

	public Point getC() {
		return c;
	}

	public void setC(Point c) {
		this.c = c;
	}

	@Override
	public double getPerimeter() {
		return a.getDistance(b) + b.getDistance(c) + c.getDistance(a);
	}

	@Override
	public double getArea() {
		double semiperimeter = (a.getDistance(b) + b.getDistance(c) + c.getDistance(a)) / 2;
		return Math.sqrt(semiperimeter * (semiperimeter - a.getDistance(b)) * (semiperimeter - b.getDistance(c)) * (semiperimeter - c.getDistance(a)));
	}

	@Override
	public String toString() {
		return "Triangle [A = " + a + ", B = " + b + ", C = " + c + ", perimeter = " + getPerimeter() + ", area = "
				+ getArea() + "]";
	}

}
