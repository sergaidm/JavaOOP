package ru.yandex.sergaidm;

//Describe the class "Vector3d" (a vector in a three-dimensional coordinate system). 
//Properties of this class must be coordinates of vector. 
//For this class create methods of addition, scalar and vector multiplication of vectors. 
//Create several objects of this class and test them.

public class Main {

	public static void main(String[] args) {

		Vector3d vector = new Vector3d();

		Vector3d vector1 = new Vector3d(0, 1, 0);
		Vector3d vector2 = new Vector3d(1, 0, 2);

		System.out.println();
		System.out.println("Coordinates of the first  vector: " + vector1);
		System.out.println("Coordinates of the second vector: " + vector2);

		Vector3d add = vector.addition(vector1, vector2);
		double sp = vector.scalarMultiplication(vector1, vector2);
		Vector3d vp = vector.vectorMultiplication(vector1, vector2);

		System.out.println();
		System.out.println("Addition of these vectors: " + add);
		System.out.println("Scalar multiplication of these vectors = " + sp);
		System.out.println("Vector multiplication of these vectors: " + vp);
		System.out.println();

		Vector3d vector3 = new Vector3d(-1, -2, -3);
		Vector3d vector4 = new Vector3d(5.5, 10.3, 20.1);

		System.out.println("Coordinates of the third  vector: " + vector3);
		System.out.println("Coordinates of the fourth vector: " + vector4);
		System.out.println();

		System.out.println("Addition of these vectors: " + vector.addition(vector3, vector4));
		System.out.println("Scalar multiplication of these vectors = " + vector.scalarMultiplication(vector3, vector4));
		System.out.println("Vector multiplication of these vectors: " + vector.vectorMultiplication(vector3, vector4));

	}

}
