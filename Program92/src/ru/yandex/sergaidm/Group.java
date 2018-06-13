package ru.yandex.sergaidm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Group {

	private List<Student> group;

	public Group() {
		group = new ArrayList<>();
	}

	public void addStudent(String surname, double age, char gender, String groupName) {
		group.add(new Student(surname, age, gender, groupName));
	}

	public void printGroup() {
		System.out.println(group);
	}

	public void deleteStudent(int place) throws GroupException {
		if (place >= 0 & place < group.size()) {
			System.out.println(group.get(place).getSurname() + " is expelled from the group");
			group.remove(place);
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

	public void sortingOfStudents() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input parameter of sorting from 1 to 4: ");
		int parameter = sc.nextInt();
		sc.close();
		if (parameter == 1) {
			Sorting.ascendingSortingBySurname(group);
		} else if (parameter == 2) {
			Sorting.descendingSortingBySurname(group);
		} else if (parameter == 3) {
			Sorting.ascendingSortingByAge(group);
		} else if (parameter == 4) {
			Sorting.descendingSortingByAge(group);
		}
		System.out.println("Sorted array of students by " + parameter + " parameter: " + "\n");
		printGroup();
	}

}
