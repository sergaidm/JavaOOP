package ru.yandex.sergaidm;

import java.io.Serializable;

public class Group implements Serializable {

	private static final long serialVersionUID = 1L;
	private Student[] group;

	public Group() {
		group = new Student[0];
	}

	public void addStudent(String surname, double age, char gender, String groupName) {
		Student[] st = new Student[group.length + 1];
		System.arraycopy(group, 0, st, 0, group.length);
		st[st.length - 1] = new Student(surname, age, gender, groupName);
		group = st;
	}

	public void printGroup() {
		for (Student st : group) {
			System.out.println(st);
		}
	}	

}
