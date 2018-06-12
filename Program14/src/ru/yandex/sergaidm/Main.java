package ru.yandex.sergaidm;

public class Main {

	public static void main(String[] args) {

		Network mts = new Network("MTS");
		Network life = new Network("Life");
		Network kievstar = new Network("KievStar");
		
		Phone phoneOne = new Phone("Samsung Galaxy Note 8", "0991111111");
		Phone phoneTwo = new Phone("iPhone X", "0992222222");
		Phone phoneThree = new Phone("Xiaomi Redmi Note 5A", "0993333333");
		Phone phoneFour = new Phone("Neo N003", "0994444444");
		Phone phoneFive = new Phone("Meizu Pro 7 Plus", "0995555555");
		
		phoneOne.registerToNetwork(mts);
		phoneTwo.registerToNetwork(mts);
		phoneTwo.registerToNetwork(mts);
		mts.printNetwork();
		phoneThree.registerToNetwork(life);
		life.printNetwork();
		phoneFour.registerToNetwork(kievstar);
		kievstar.printNetwork();
		
		System.out.println();
		phoneOne.call(phoneTwo.getNumber());		
		phoneFour.call("0996666666");
		phoneFive.call(phoneThree.getNumber());
		
	}

}
