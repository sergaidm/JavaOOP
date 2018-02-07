package ru.yandex.sergaidm;

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
		
	}
}