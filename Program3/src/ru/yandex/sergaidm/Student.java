package ru.yandex.sergaidm;

public class Student extends Human {

	private String university;

	public Student(String surname, double age, boolean gender, String university) {
		super(surname, age, gender);
		this.university = university;
	}

	public Student() {
		super();
	}

	public Student(String surname, double age, boolean gender) {
		super(surname, age, gender);
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	@Override
	public String toString() {
		return "(" + super.toString() + university + ")";
	}

}
