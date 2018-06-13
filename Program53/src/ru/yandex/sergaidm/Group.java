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

	public void addStudentToGroup(Student student) throws GroupException {
		if (student == null) {
			throw new IllegalArgumentException("Empty student");
		}
		for (int i = 0; i < group.length; i++) {
			if (group[i] == null) {
				group[i] = student;
				return;
			}
		}
		throw new GroupException("This place of group is taken by another student");
	}

	public void deleteStudentFromGroup(Student student, int place) throws GroupException {
		if (place >= 0 & place < group.length) {
			group[place] = null;
			System.out.println("The " + (place + 1) + " student is expelled from the group");
		} else {
			throw new GroupException("There is no such student in the group");
		}
	}
	
	public Student[] getStudentsArray() {
		Student[] studentsArray = new Student[this.group.length];
		System.arraycopy(group, 0, studentsArray, 0, group.length);
		return studentsArray;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(System.lineSeparator() + Arrays.toString(group));
		return sb.toString();
	}

}
