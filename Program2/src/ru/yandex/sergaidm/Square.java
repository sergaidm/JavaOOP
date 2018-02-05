package ru.yandex.sergaidm;

public class Square extends Shape {

	private Point A;
	private Point B;
	private Point C;
	private Point D;
	
	public Square(Point a, Point b, Point c, Point d) {
		super();
		A = a;
		B = b;
		C = c;
		D = d;
	}

	public Square() {
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

	public Point getD() {
		return D;
	}

	public void setD(Point d) {
		D = d;
	}

	@Override
	public double getPerimetr() {
		return A.distance(B) + B.distance(C) + C.distance(D)+ D.distance(A);
	}

	@Override
	public double getArea() {
		return Math.pow(A.distance(B), 2);
	}

	@Override
	public String toString() {
		return "Square [A=" + A + ", B=" + B + ", C=" + C + ", D=" + D + ", getPerimetr()=" + getPerimetr()
				+ ", getArea()=" + getArea() + "]";
	}

}
