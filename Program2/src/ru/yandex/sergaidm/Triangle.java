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
		a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		b = b;
	}

	public Point getC() {
		return c;
	}

	public void setC(Point c) {
		c = c;
	}

	@Override
	public double getPerimetr() {
		return a.distance(b) + b.distance(c) + c.distance(a);
	}

	@Override
	public double getArea() {

		double polP = (a.distance(b) + b.distance(c) + c.distance(a)) / 2;
		return Math.sqrt(polP * (polP - a.distance(b)) * (polP - b.distance(c)) * (polP - c.distance(a)));
	}

	@Override
	public String toString() {
		return "Triangle [A=" + a + ", B=" + b + ", C=" + c + ", getPerimetr()=" + getPerimetr() + ", getArea()="
				+ getArea() + "]";
	}

}
