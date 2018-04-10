package ru.yandex.sergaidm;

public class Student extends Human {

	private String group;

	public Student(String surname, double age, char gender, String groupName) {
		super(surname, age, gender);
		this.group = groupName;
	}

	public Student() {
		super();
	}

	public Student(String surname, double age, char gender) {
		super(surname, age, gender);
	}

	public String getGroupName() {
		return group;
	}

	public void setGroupName(String groupName) {
		this.group = groupName;
	}

	@Override
	public String toString() {
		return "(" + super.toString() + group + ")";
	}

}
