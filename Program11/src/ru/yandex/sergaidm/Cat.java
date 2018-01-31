package ru.yandex.sergaidm;

public class Cat {

	private String breed;
	private String color;
	private double weight;
	private int age;

	public Cat(String breed, String color, double weight, int age) {
		super();
		this.breed = breed;
		this.color = color;
		this.weight = weight;
		this.age = age;
	}

	public Cat() {
		super();
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void meow() {
		System.out.println("Ñat can meow");
	}
	
	public void jump() {
		System.out.println("Cat can jump");
	}

	@Override
	public String toString() {
		return "Cat [breed=" + breed + ", color=" + color + ", weight=" + weight + ", age=" + age + "]";
	}
	
}
