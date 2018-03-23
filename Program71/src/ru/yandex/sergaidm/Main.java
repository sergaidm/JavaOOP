package ru.yandex.sergaidm;

public class Main {

	public static void main(String[] args) {
		
		SynchClass sClass = new SynchClass(2);
		Harbor harbor = new Harbor(sClass);
		
		Thread shipOne = new Thread(harbor, "Arabella");
		Thread shipTwo = new Thread(harbor, "Sinko L'iagas");
		Thread shipThree = new Thread(harbor, "La Fudr");

		shipOne.start();
		shipTwo.start();
		shipThree.start();

	}

}
