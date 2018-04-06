package ru.yandex.sergaidm;

public class Ship implements Runnable {

	private String name;
	private int boxes = 10;

	public Ship(String name, int boxes) {
		super();
		this.name = name;
		this.boxes = boxes;
	}

	public Ship() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void unloadingShip() {
		System.out.println(name + " is started unloading");
		for (; boxes > 0;) {
			try {
				Thread.sleep(500);
				boxes--;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " has " + boxes + " boxes");
		}
		if (boxes == 0) {
			System.out.println(name + " completed unloading");
		}
	}

	@Override
	public void run() {		
		unloadingShip();		
	}

}
