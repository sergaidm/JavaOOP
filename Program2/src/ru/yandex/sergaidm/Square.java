package ru.yandex.sergaidm;

public class Square extends Shape {

	private Point a;
	private Point b;
	private Point c;
	private Point d;
	
	public Square(Point a, Point b, Point c, Point d) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public Square() {
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

	public Point getD() {
		return d;
	}

	public void setD(Point d) {
		d = d;
	}

	@Override
	public double getPerimetr() {
		return a.distance(b) + b.distance(c) + c.distance(d)+ d.distance(a);
	}

	@Override
	public double getArea() {
		return Math.pow(a.distance(b), 2);
	}

	@Override
	public String toString() {
		return "Square [A=" + a + ", B=" + b + ", C=" + c + ", D=" + d + ", getPerimetr()=" + getPerimetr()
				+ ", getArea()=" + getArea() + "]";
	}

}
