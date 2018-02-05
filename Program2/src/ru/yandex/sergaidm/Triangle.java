package ru.yandex.sergaidm;

public class Triangle extends Shape {

	private Point A;
	private Point B;
	private Point C;

	public Triangle(Point a, Point b, Point c) {
		super();
		A = a;
		B = b;
		C = c;
	}

	public Triangle() {
		super();

	}

	public Point getA() {
		return A;
	}

	public void setA(Point a) {
		A = a;
	}

	public Point getB() {
		return B;
	}

	public void setB(Point b) {
		B = b;
	}

	public Point getC() {
		return C;
	}

	public void setC(Point c) {
		C = c;
	}

	@Override
	public double getPerimetr() {
		return A.distance(B) + B.distance(C) + C.distance(A);
	}

	@Override
	public double getArea() {

		double polP = (A.distance(B) + B.distance(C) + C.distance(A)) / 2;
		return Math.sqrt(polP * (polP - A.distance(B)) * (polP - B.distance(C)) * (polP - C.distance(A)));
	}

	@Override
	public String toString() {
		return "Triangle [A=" + A + ", B=" + B + ", C=" + C + ", getPerimetr()=" + getPerimetr() + ", getArea()="
				+ getArea() + "]";
	}

}
