package ru.yandex.sergaidm;

//Describe the class "Triangle". The properties of this class should be lengths of the sides of triangle. 
//Create a method that will return the area of this triangle. 
//Create several objects of this class and test them.

public class Main {

	public static void main(String[] args) {

		Triangle triangleOne = new Triangle();
		triangleOne.setA(5);
		triangleOne.setB(7);
		triangleOne.setC(8);
		System.out.println("The first  triangle: " + triangleOne);
		if (triangleOne.realTriangle(5, 7, 8) == true) {
			System.out.println("Area of this triangle S = " + triangleOne.getArea(5, 7, 8));
		} else if (triangleOne.realTriangle(5, 7, 8) == false) {
			System.err.println("This triangle is unreal. Input the correct triangle sides lengths");
		}
		System.out.println();

		Triangle triangleTwo = new Triangle(5, 5, 5);
		System.out.println("The second triangle: " + triangleTwo);
		if (triangleTwo.realTriangle(5, 5, 5) == true) {
			System.out.println("Area of this triangle S = " + triangleTwo.getArea(5, 5, 5));
		} else if (triangleTwo.realTriangle(5, 5, 5) == false) {
			System.err.println("This triangle is unreal. Input the correct triangle sides lengths");
		}
		System.out.println();

		Triangle triangleThree = new Triangle(2, 8, 20);
		System.out.println("The third  triangle: " + triangleThree);
		if (triangleThree.realTriangle(2, 8, 20) == true) {
			System.out.println("Area of this triangle S = " + triangleThree.getArea(2, 8, 20));
		} else if (triangleThree.realTriangle(2, 8, 20) == false) {
			System.err.println("This triangle is unreal. Input the correct triangle sides lengths");
		}

	}
}
