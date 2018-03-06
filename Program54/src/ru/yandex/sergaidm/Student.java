package ru.yandex.sergaidm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Student extends Human {

	private String university;

	public Student(String surname, double age, String gender, String university) {
		super(surname, age, gender);
		this.university = university;
	}

	public Student() {
		super();
	}

	public Student(String surname, double age, String gender) {
		super(surname, age, gender);
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public static String[] loadTextFromFile(File file) {
		String text = "";
		String[] t = new String[text.length()];
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			for (; (text = br.readLine()) != null;) {
				sb.append(text + " ");
				String str = sb.toString();
				t = str.split(" ");
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return t;
	}

	public static Student[] getArrayOfStudents(File file, String[] t) {
		String surname = "";
		double age = 0;
		String gender = "";
		String university = "";
		Student st = new Student();
		Student[] students = new Student[t.length / 4];
		for (int i = 0; i < t.length; i += 4) {
			surname = t[i];
			age = Double.parseDouble(t[i + 1]);
			gender = t[i + 2];
			university = t[i + 3];
			st = new Student(surname, age, gender, university);
			for (int j = 0; j < students.length; j++) {
				if (students[j] == null) {
					students[j] = st;
					break;
				}
			}
		}
		return students;
	}

	@Override
	public String toString() {
		return "(" + super.toString() + university + ")";
	}

}
