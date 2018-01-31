package ru.yandex.sergaidm;

//Describe the class "Cat". Give it the properties and methods. 
//Create several objects of this class. Use these objects.

public class Main {

	public static void main(String[] args) {

		Cat cat = new Cat();
		cat.meow();
		cat.jump();

		Cat catOne = new Cat("Indian", "Black", 6.5, 5);
		System.out.println(catOne);

		Cat catTwo = new Cat("British", "Grey", 12, 8);
		System.out.println(catTwo);

		Cat catThree = new Cat("Scottish fold", "White", 9.2, 3);
		System.out.println(catThree);

	}

}
