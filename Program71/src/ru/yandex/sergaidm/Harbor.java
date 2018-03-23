package ru.yandex.sergaidm;

public class Harbor implements Runnable {

	private SynchClass sClass;

	public Harbor(SynchClass sClass) {
		super();
		this.sClass = sClass;
	}

	public Harbor() {
		super();
	}

	@Override
	public void run() {
		sClass.unloadingShip(10);
	}

}
