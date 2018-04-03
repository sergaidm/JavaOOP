package ru.yandex.sergaidm;

import java.io.Serializable;

public class Student extends Human implements Serializable {

	private static final long serialVersionUID = 1L;
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
