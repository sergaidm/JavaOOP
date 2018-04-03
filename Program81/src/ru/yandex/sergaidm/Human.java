package ru.yandex.sergaidm;

import java.io.Serializable;

public class Human implements Serializable {

	private static final long serialVersionUID = 1L;
	private String surname;
	private double age;
	private char gender;

	public Human(String surname, double age, char gender) {
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return surname + ", " + age + ", " + String.valueOf(gender) + ", ";
	}

}
