package ru.yandex.sergaidm;

public class Main {

	public static void main(String[] args) {
		
		Harbor harbor = new Harbor(2);
		
		Ship shipOne = new Ship("Arabella", 10);
		Ship shipTwo = new Ship("Sinko L'iagas", 10);
		Ship shipThree = new Ship("La Fudr", 10);

		harbor.harborWork(shipOne);
		harbor.harborWork(shipTwo);
		harbor.harborWork(shipThree);
		harbor.harborEndWork();
	}

}
