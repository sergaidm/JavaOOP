package ru.yandex.sergaidm;

/*Describe the class "Triangle". The properties of this class should be lengths of the sides 
of triangle. Create a method that will return the area of this triangle. 
Create several objects of this class and test them.*/

public class Main {

	public static void main(String[] args) {

		Triangle triangleOne = new Triangle();
		triangleOne.setA(5);
		triangleOne.setB(7);
		triangleOne.setC(8);
		System.out.println("The first  triangle: " + triangleOne);
		if (triangleOne.realTriangle() == true) {
			System.out.println("Area of this triangle S = " + triangleOne.getArea());
		} else if (triangleOne.realTriangle() == false) {
			System.err.println("This triangle is unreal. Input the correct triangle sides lengths");
		}
		System.out.println();

		Triangle triangleTwo = new Triangle(5, 5, 5);
		System.out.println("The second triangle: " + triangleTwo);
		if (triangleTwo.realTriangle() == true) {
			System.out.println("Area of this triangle S = " + triangleTwo.getArea());
		} else if (triangleTwo.realTriangle() == false) {
			System.err.println("This triangle is unreal. Input the correct triangle sides lengths");
		}
		System.out.println();

		Triangle triangleThree = new Triangle(2, 8, 20);
		System.out.println("The third  triangle: " + triangleThree);
		if (triangleThree.realTriangle() == true) {
			System.out.println("Area of this triangle S = " + triangleThree.getArea());
		} else if (triangleThree.realTriangle() == false) {
			System.err.println("This triangle is unreal. Input the correct triangle sides lengths");
		}

	}
}
