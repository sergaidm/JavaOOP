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

	public static Vector3d addition(Vector3d vectorOne, Vector3d vectorTwo) {
		return new Vector3d(vectorOne.getX() + vectorTwo.getX(), vectorOne.getY() + vectorTwo.getY(),
				vectorOne.getZ() + vectorTwo.getZ());
	}

	public static double scalarMultiplication(Vector3d vectorOne, Vector3d vectorTwo) {
		return (vectorOne.getX() * vectorTwo.getX()) + (vectorOne.getY() * vectorTwo.getY())
				+ (vectorOne.getZ() * vectorTwo.getZ());
	}

	public static Vector3d vectorMultiplication(Vector3d vectorOne, Vector3d vectorTwo) {
		return new Vector3d((vectorOne.getY() * vectorTwo.getZ()) - (vectorOne.getZ() * vectorTwo.getY()),
				(vectorOne.getZ() * vectorTwo.getX()) - (vectorOne.getX() * vectorTwo.getZ()),
				(vectorOne.getX() * vectorTwo.getY()) - (vectorOne.getY() * vectorTwo.getX()));
	}

	@Override
	public String toString() {
		return "[x = " + x + ", y = " + y + ", z = " + z + "]";
	}

}
