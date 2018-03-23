package ru.yandex.sergaidm;

import java.util.concurrent.Semaphore;

public class SynchClass {

	private int docks;
	private Semaphore semaphore = new Semaphore(docks);

	public SynchClass(int docks) {
		super();
		this.docks = docks;
	}

	public void unloadingShip(int boxes) {
		Thread thr = Thread.currentThread();
		System.out.println(thr.getName() + " is started unloading");
		try {
			System.out.println(thr.getName() + " waiting its turn");
			semaphore.acquire();
			for (; boxes > 0;) {
				try {
					thr.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(thr.getName() + " has " + boxes + " boxes");
				boxes--;
			}
			if (boxes == 0) {
				System.out.println(thr.getName() + " completed unloading");
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		} finally {
			semaphore.release();
		}
	}

}
