package ru.yandex.sergaidm;

public class Triangle {

	private double a;
	private double b;
	private double c;

	public Triangle(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Triangle() {
		super();
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double getArea() {
		double p = (a + b + c) / 2;
		double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		return s;
	}

	public boolean realTriangle() {
		if (((a + b) > c) & ((a + c) > b) & ((b + c) > a)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "[a = " + a + ", b = " + b + ", c = " + c + "]";
	}

}
