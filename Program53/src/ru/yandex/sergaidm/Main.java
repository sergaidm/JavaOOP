package ru.yandex.sergaidm;

/*Improve class Group by adding the ability to save group to file.*/

import java.io.File;

public class Main {
	public static void main(String[] args) {

		Student one = new Student("Ivanov", 17.5, "male", "KPI");
		Student two = new Student("Petrov", 19.5, "male", "NAU");
		Student three = new Student("Sidorov", 20, "male", "MSU");
		Student four = new Student("Orlov", 21, "male", "UO");
		Student five = new Student("Arbuzov", 22, "male", "BU");
		Student six = new Student("Sokolov", 17, "male", "PU");
		Student seven = new Student("Fedorova", 17.5, "female", "LU");
		Student eight = new Student("Andreeva", 18, "female", "WU");
		Student nine = new Student("Sergeeva", 19, "female", "KU");
		Student ten = new Student("Konstantinova", 17, "female", "TU");

		Group gr = new Group();

		try {
			gr.addStudentToGroup(one, 0);
			gr.addStudentToGroup(two, 1);
			gr.addStudentToGroup(three, 2);
			gr.addStudentToGroup(four, 3);
			gr.addStudentToGroup(five, 4);
			gr.addStudentToGroup(six, 5);
			gr.addStudentToGroup(seven, 6);
			gr.addStudentToGroup(eight, 7);
			gr.addStudentToGroup(nine, 8);
			gr.addStudentToGroup(ten, 9);
		} catch (GroupException e) {
			System.out.println(e);
		}
		System.out.println("\n" + gr + "\n");

		File groupList = new File("groupList.txt");
		Group.saveToFile(gr, groupList);

		System.out.println("Group list saved to specified file");

	}
}
