package ru.yandex.sergaidm;

public class Vector3d {

	private double x;
	private double y;
	private double z;

	public Vector3d(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3d() {
		super();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public static Vector3d addition(Vector3d vector1, Vector3d vector2) {

		Vector3d add = new Vector3d(vector1.getX() + vector2.getX(), vector1.getY() + vector2.getY(),
				vector1.getZ() + vector2.getZ());

		return add;

	}

	public static double scalarMultiplication(Vector3d vector1, Vector3d vector2) {

		double sm = (vector1.getX() * vector2.getX()) + (vector1.getY() * vector2.getY())
				+ (vector1.getZ() * vector2.getZ());

		return sm;
	}

	public static Vector3d vectorMultiplication(Vector3d vector1, Vector3d vector2) {

		Vector3d vm = new Vector3d((vector1.getY() * vector2.getZ()) - (vector1.getZ() * vector2.getY()),
				(vector1.getZ() * vector2.getX()) - (vector1.getX() * vector2.getZ()),
				(vector1.getX() * vector2.getY()) - (vector1.getY() * vector2.getX()));

		return vm;
	}

	@Override
	public String toString() {
		return "[x = " + x + ", y = " + y + ", z = " + z + "]";
	}

}
