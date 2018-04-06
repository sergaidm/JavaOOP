package ru.yandex.sergaidm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Harbor {

	private int docks = 2;
	ExecutorService harbor;

	public Harbor(int docks) {
		super();
		this.docks = docks;
		harbor = Executors.newFixedThreadPool(docks);
	}

	public Harbor() {
		super();
		harbor = Executors.newFixedThreadPool(docks);
	}

	public void harborWork(Ship ship) {
		harbor.submit(ship);
	}
	
	public void harborEndWork() {
		harbor.shutdown();
	}

}
