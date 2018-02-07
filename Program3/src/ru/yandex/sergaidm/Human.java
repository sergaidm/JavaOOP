package ru.yandex.sergaidm;

public class Human {

	private String surname;
	private double age;
	private boolean gender;

	public Human(String surname, double age, boolean gender) {
		super();
		this.surname = surname;
		this.age = age;
		this.gender = gender;
	}

	public Human() {
		super();
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return surname + ", " + age + ", ";
	}

}
