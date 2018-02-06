package ru.yandex.sergaidm;

public class Circle extends Shape {

	private Point a;
	private Point o;

	public Circle(Point a, Point o) {
		super();
		this.a = a;
		this.o = o;
	}

	public Circle() {
		super();
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		a = a;
	}

	public Point getO() {
		return o;
	}

	public void setO(Point o) {
		o = o;
	}

	@Override
	public double getPerimetr() {
		return 2 * Math.PI * a.distance(o);
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(a.distance(o), 2);
	}

	@Override
	public String toString() {
		return "Circle [A=" + a + ", O=" + o + ", getPerimetr()=" + getPerimetr() + ", getArea()=" + getArea() + "]";
	}

}
