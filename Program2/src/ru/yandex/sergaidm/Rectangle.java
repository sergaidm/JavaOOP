package ru.yandex.sergaidm;

public class Rectangle extends Shape {

	private Point a;
	private Point b;
	private Point c;
	private Point d;

	public Rectangle(Point a, Point b, Point c, Point d) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public Rectangle() {
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

	public Point getD() {
		return d;
	}

	public void setD(Point d) {
		this.d = d;
	}

	@Override
	public double getPerimeter() {
		return a.getDistance(b) + b.getDistance(c) + c.getDistance(d) + d.getDistance(a);
	}

	@Override
	public double getArea() {
		Triangle triangleOne = new Triangle(a, b, c);
		Triangle triangleTwo = new Triangle(a, c, d);
		return triangleOne.getArea() + triangleTwo.getArea();
	}

	@Override
	public String toString() {
		return "Rectangle [A = " + a + ", B = " + b + ", C = " + c + ", D = " + d + ", perimeter = " + getPerimeter()
				+ ", area = " + getArea() + "]";
	}

}
