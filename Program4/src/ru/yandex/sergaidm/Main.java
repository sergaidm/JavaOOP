package ru.yandex.sergaidm;

/*Improve the class Group by adding the ability to interactively adding an object.
 *Realize ability to sort the list of students by parameter (surname, age, etc.)
 *Realize interface Military Commissar, which will return array of students - young men 
 *from the group, who are over 18 years old.*/

import javax.swing.JOptionPane;

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

		Group gr2 = new Group();
		for (int i = 0; i < 3; i++) {
			try {
				gr2.interactiveAddStudentToGroup();
			} catch (IllegalArgumentException e) {
				System.out.println(e);
			}
		}
		System.out.println("\n" + gr2 + "\n");

		Student[] students = { one, two, three, four, five, six, seven, eight, nine, null };
		System.out.println("Unsorted array of students: " + "\n");
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println();

		int parameter = 1;
		String input = "";
		for (;;) {
			try {
				input = JOptionPane.showInputDialog("Input version of sorting students (from 1 to 8): " + "\n"
						+ "1 - ascending sorting by surname;" + "\n" + "2 - descending sorting by surname;" + "\n"
						+ "3 - ascending sorting by age;" + "\n" + "4 - descending sorting by age;" + "\n"
						+ "5 - ascending sorting by gender;" + "\n" + "6 - descending sorting by gender;" + "\n"
						+ "7 - ascending sorting by university;" + "\n" + "8 - descending sorting by university.");
				if (input == null) {
					throw new NullPointerException();
				}
				parameter = Integer.parseInt(input);
				if (parameter <= 0 | parameter >= 9) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error number format");
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Parameter must be from 1 to 8");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Canceled. Set default value");
				break;
			}
		}

		if (parameter == 1) {
			Sorting.ascendingSortingBySurname(students);
		} else if (parameter == 2) {
			Sorting.descendingSortingBySurname(students);
		} else if (parameter == 3) {
			Sorting.ascendingSortingByAge(students);
		} else if (parameter == 4) {
			Sorting.descendingSortingByAge(students);
		} else if (parameter == 5) {
			Sorting.ascendingSortingByGender(students);
		} else if (parameter == 6) {
			Sorting.descendingSortingByGender(students);
		} else if (parameter == 7) {
			Sorting.ascendingSortingByUniversity(students);
		} else if (parameter == 8) {
			Sorting.descendingSortingByUniversity(students);
		}
		System.out.println("Sorted array of students by " + parameter + " parameter: " + "\n");
		for (Student student : students) {
			System.out.println(student);
		}

		MilitaryCommissar mc = gr;
		Student[] arrayStudent = gr.isRecruit();
		System.out.println("\n" + "Students - recruits: " + "\n");
		for (Student student2 : arrayStudent) {
			System.out.println(student2);

		}
	}
}