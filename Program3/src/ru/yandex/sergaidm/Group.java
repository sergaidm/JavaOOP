package ru.yandex.sergaidm;

import java.util.Arrays;

public class Group {

	private Student student;
	private Student[] group = new Student[10];

	public Group(Student student, Student[] group) {
		super();
		this.student = student;
		this.group = group;
	}

	public Group() {
		super();
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Student[] getGroup() {
		return group;
	}

	public void setGroup(Student[] group) {
		this.group = group;
	}

	public void addStudentToGroup(Student student, int place) throws GroupException {

		if (place >= 0 & place < group.length) {
			group[place] = student;
			System.out.println("The student is added to " + (place + 1) + " place of the group");
		} else {
			throw new GroupException("In group there are no more free places");
		}

	}

	public void delStudentfromGroup(Student student, int place) throws GroupException {

		if (place >= 0 & place < group.length) {
			group[place] = null;
			System.out.println("The " + (place + 1) + " student is expelled from the group");
		} else {
			throw new GroupException("There is no such student in the group");
		}

	}

	public Student searchStudent(String surname) {

		Student st = new Student();
		for (int i = 0; i < group.length; i++) {
			if (surname.equals(group[i].getSurname())) {
				System.out.println("This student exists in the group" + st);
			} else if (group[i] == null) {
				System.out.println("This student doesn't exist in the group" + st);
			}
		}

		return st;

	}

	public void studentsSorting(String surname) {
		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String text = "\tGroup of students: ";
		sb.append(text + System.lineSeparator() + System.lineSeparator() + Arrays.toString(group));
		return sb.toString();
	}

}
