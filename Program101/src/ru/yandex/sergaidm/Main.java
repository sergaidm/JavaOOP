package ru.yandex.sergaidm;

public class Main {
	public static void main(String[] args) {
		Group group = new Group();

		group.addStudent("Ivanov", 22.5, 'm', "DP-51s");
		group.addStudent("Petrov", 23, 'm', "DP-51s");
		group.addStudent("Sidorov", 22.8, 'm', "DP-51s");
		group.addStudent("Orlov", 23.2, 'm', "DP-51s");
		group.addStudent("Arbuzov", 22.4, 'm', "DP-51s");
		group.addStudent("Kaktusov", 23.1, 'm', "DP-51s");
		group.addStudent("Andreeva", 23, 'f', "DP-51s");
		group.addStudent("Sergeeva", 22.9, 'f', "DP-51s");
		group.printGroup();	
		
		System.out.println(group.searchStudentByLetter('S'));
	}
}