package ru.yandex.sergaidm;

/*Create a class Human. Create a class Student that extends class Human.
 Create a class Group that contains an array of 10 objects of class Student.
 Create methods for adding, deleting, and searching students by surname.
 If you try to add the eleventh student you must create custom exception class 
 and process it. Determine toString() method for Group class so that it displays 
 a list of students alphabetically.*/

public class Main {
	public static void main(String[] args) {

		Student student = new Student();
		Student one = new Student("Ivanov", 18.5, true, "KPI");
		Student two = new Student("Petrov", 19.5, true, "NAU");
		Student three = new Student("Sidorov", 20, true, "KNEU");
		Student four = new Student("Orlov", 21, true, "KNU");
		Student five = new Student("Arbuzov", 22, true, "KNUST");

		Group gr = new Group();

		try {
			gr.addStudentToGroup(one, 1);
			gr.addStudentToGroup(two, 3);
			gr.addStudentToGroup(three, 5);
			gr.addStudentToGroup(four, 7);
			gr.addStudentToGroup(five, 9);
		} catch (GroupException e) {
			System.out.println(e);
		}
		System.out.println();
		System.out.println(gr);
		System.out.println();

		try {
			gr.addStudentToGroup(two, 1);
		} catch (GroupException e) {
			System.out.println(e);
		}
		System.out.println();
		System.out.println(gr);
		System.out.println();

		try {
			gr.addStudentToGroup(one, 11);
		} catch (GroupException e) {
			System.out.println(e);
		}
		System.out.println();
		System.out.println(gr);
		System.out.println();

		try {
			gr.delStudentfromGroup(student, 5);
		} catch (GroupException e) {
			System.out.println(e);
		}
		System.out.println();
		System.out.println(gr);
		System.out.println();

		try {
			System.out.println(gr.searchStudent("Petrov"));
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		System.out.println();

		try {
			gr.addStudentToGroup(five, 0);
			gr.addStudentToGroup(one, 2);
			gr.addStudentToGroup(two, 4);
			gr.addStudentToGroup(three, 5);
			gr.addStudentToGroup(three, 6);
			gr.addStudentToGroup(four, 8);
		} catch (GroupException e) {
			System.out.println(e);
		}
		System.out.println();
		System.out.println(gr);
		System.out.println();

		try {
			gr.sortingOfStudents();
			System.out.println("  Alphabetical order of" + gr);
		} catch (NullPointerException e) {
			System.out.println(e);
		}

	}
}