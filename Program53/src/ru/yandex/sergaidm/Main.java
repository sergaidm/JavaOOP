package ru.yandex.sergaidm;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		Group groupOne = new Group();
		try {
			groupOne.addStudentToGroup(new Student("Ivanov", 17.5, "male", "KPI"));
			groupOne.addStudentToGroup(new Student("Petrov", 19.5, "male", "NAU"));
			groupOne.addStudentToGroup(new Student("Sidorov", 20, "male", "MSU"));
			groupOne.addStudentToGroup(new Student("Orlov", 21, "male", "UO"));
			groupOne.addStudentToGroup(new Student("Arbuzov", 22, "male", "BU"));
			groupOne.addStudentToGroup(new Student("Sokolov", 17, "male", "PU"));
			groupOne.addStudentToGroup(new Student("Fedorova", 17.5, "female", "LU"));
			groupOne.addStudentToGroup(new Student("Andreeva", 18, "female", "WU"));
			groupOne.addStudentToGroup(new Student("Sergeeva", 19, "female", "KU"));
			groupOne.addStudentToGroup(new Student("Konstantinova", 17, "female", "TU"));
		} catch (GroupException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("List of students being written to file:" + groupOne);

		File folder = new File("Groups");
		folder.mkdirs();
		GroupDAO groupDAO = new GroupDAOTXTFileImplementation(folder);
		GroupController controller = new GroupController(groupDAO);
		controller.saveGroupToFile(groupOne);
		System.out.println();
		Group groupTwo = controller.loadGroupFromFile();
		System.out.println("List of students being read from file:" + groupTwo);

	}

}
