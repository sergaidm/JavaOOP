package ru.yandex.sergaidm;

/*Read information about group from file 
 * and on their basis create object of class Group*/

import java.io.File;

public class Main {
	public static void main(String[] args) {

		File groupList = new File("groupList.txt");
		Student student = new Student();
		Group gr = new Group();
		Student[] studentsArray = student.getArrayOfStudents(groupList, student.loadTextFromFile(groupList));

		for (int i = 0; i < studentsArray.length; i++) {
			try {
				gr.addStudentToGroup(studentsArray[i], i);
			} catch (GroupException e) {
				System.out.println(e);
			}
		}

		System.out.println("\n" + gr + "\n");
	}
}
