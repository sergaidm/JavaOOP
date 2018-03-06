package ru.yandex.sergaidm;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

	private static String textToCSV(Group group) {
		StringBuilder sb = new StringBuilder();
		String text = group.toString();
		text = text.substring(text.indexOf("("), text.lastIndexOf("]"));
		text = text.replace("), ", "");
		text = text.replace(" ", "");
		text = text.replace(")", "");
		String t[] = text.split("[(]");
		for (String string : t) {
			sb.append(string + System.lineSeparator());
		}
		return sb.toString();
	}

	public static void saveToFile(Group group, File file) {
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(textToCSV(group));
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String text = "\tGroup of students: ";
		sb.append(text + System.lineSeparator() + System.lineSeparator() + Arrays.toString(group));
		return sb.toString();
	}

}
