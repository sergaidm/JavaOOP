package ru.yandex.sergaidm;

public class Human {

	private String surname;
	private double age;
	private String gender;

	public Human(String surname, double age, String gender) {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return surname + ", " + age + ", " + gender + ", ";
	}

}
