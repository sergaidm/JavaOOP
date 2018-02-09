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

	public boolean addStudentToGroup(Student student, int place) throws GroupException {
		boolean r = false;
		for (Student anotherStudent : group) {
			if (place > group.length) {
				throw new GroupException("In group there are no more free places");
			} else if (group[place] == null) {
				group[place] = student;
				System.out.println("The student is added to " + (place + 1) + " place of the group");
				return r = true;
			}
			if (group[place] != null) {
				System.out.println("Impossible to add student to " + (place + 1) + " place of the group");
				throw new GroupException("This place of group is taken by another student");
			}
		}
		return r;
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

		for (Student student : group) {
			if (student != null && student.getSurname().equals(surname)) {
				return student;
			}
		}
		return null;
	}

	public Student sortingOfStudents() {

		Student st = new Student();
		for (int i = 1; i < group.length; i++) {
			for (int j = group.length - 1; j >= i; j--) {
				if (group[j - 1] != null && group[j] != null
						&& group[j - 1].getSurname().compareTo((group[j].getSurname())) > 0) {
					st = group[j - 1];
					group[j - 1] = group[j];
					group[j] = st;
				}
			}
		}
		return st;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String text = "\tGroup of students: ";
		sb.append(text + System.lineSeparator() + System.lineSeparator() + Arrays.toString(group));
		return sb.toString();
	}

}
