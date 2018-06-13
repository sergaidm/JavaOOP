package ru.yandex.sergaidm;

import java.io.File;

public class Main {
	
	public static void main(String[] args) {

		File file = new File("Database.txt");		
		Faculty facultyOfElectronics = new Faculty();
		
		Group groupOne = new Group();
		groupOne.addStudent("Ivanov", 22.5, 'm', "DP-51s");
		groupOne.addStudent("Petrov", 23, 'm', "DP-51s");
		groupOne.addStudent("Sidorov", 22.8, 'm', "DP-51s");
		groupOne.addStudent("Orlov", 23.2, 'm', "DP-51s");
				
		Group groupTwo = new Group();		
		groupTwo.addStudent("Arbuzov", 22.4, 'm', "DM-51m");
		groupTwo.addStudent("Kaktusov", 23.1, 'm', "DM-51m");
		groupTwo.addStudent("Andreeva", 23, 'f', "DM-51m");
		groupTwo.addStudent("Sergeeva", 22.9, 'f', "DM-51m");
		
		Group groupThree = new Group();		
		groupThree.addStudent("Morkovkin", 17, 'm', "DP-11");
		groupThree.addStudent("Ogurcov", 17.5, 'm', "DP-11");
		groupThree.addStudent("Kartoshkin", 18, 'm', "DP-11");
		groupThree.addStudent("Bananova", 18, 'f', "DP-11");
		groupThree.addStudent("Bulochkina", 17.5, 'f', "DP-11");
		groupThree.addStudent("Pomidorova", 17, 'f', "DP-11");

		facultyOfElectronics.addGroup(groupOne);
		facultyOfElectronics.addGroup(groupTwo);
		facultyOfElectronics.addGroup(groupThree);	
		
		facultyOfElectronics.writeFaculty(facultyOfElectronics, file);
		facultyOfElectronics.readFaculty(file);
		
	}
	
}