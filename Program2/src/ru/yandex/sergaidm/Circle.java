package ru.yandex.sergaidm;

public class Circle extends Shape {

	private Point A;
	private Point O;

	public Circle(Point a, Point o) {
		super();
		A = a;
		O = o;
	}

	public Circle() {
		super();
	}

	public Point getA() {
		return A;
	}

	public void setA(Point a) {
		A = a;
	}

	public Point getO() {
		return O;
	}

	public void setO(Point o) {
		O = o;
	}

	@Override
	public double getPerimetr() {
		return 2 * Math.PI * A.distance(O);
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(A.distance(O), 2);
	}

	@Override
	public String toString() {
		return "Circle [A=" + A + ", O=" + O + ", getPerimetr()=" + getPerimetr() + ", getArea()=" + getArea() + "]";
	}

}
