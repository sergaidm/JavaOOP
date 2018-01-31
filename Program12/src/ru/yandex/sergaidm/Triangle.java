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

	public static void getArea(double a, double b, double c) {

		if (realTriangle(a, b, c) == true) {
			double p = (a + b + c) / 2;
			double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
			System.out.println("Area of this triangle S = " + S);
		} else if (realTriangle(a, b, c) == false) {
			System.err.println("This triangle is unreal. Input the correct triangle sides lengths");
		}
	}

	public static boolean realTriangle(double a, double b, double c) {

		boolean r;
		if (((a + b) > c) & ((a + c) > b) & ((b + c) > a)) {
			r = true;
		} else {
			r = false;
		}
		return r;
	}

	@Override
	public String toString() {
		return "[a = " + a + ", b = " + b + ", c = " + c + "]";
	}

}
