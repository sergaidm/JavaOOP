package ru.yandex.sergaidm;

public class Main {

	public static void main(String[] args) {
		
		DoubleCola dc = new DoubleCola();
		
		ColaFan one = new ColaFan("Sheldon");
		ColaFan two = new ColaFan("Leonard");
		ColaFan three = new ColaFan("Volovitc");
		ColaFan four = new ColaFan("Kutrapalli");
		ColaFan five = new ColaFan("Penny");

		dc.addColaFan(one);
		dc.addColaFan(two);
		dc.addColaFan(three);
		dc.addColaFan(four);
		dc.addColaFan(five);
	
		dc.workCola(100);
		dc.printQueue();

	}

}
