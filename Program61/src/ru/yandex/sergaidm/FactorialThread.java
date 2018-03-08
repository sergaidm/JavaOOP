package ru.yandex.sergaidm;

import java.math.BigInteger;

public class FactorialThread implements Runnable {
	private int number;

	public FactorialThread(int number) {
		super();
		this.number = number;
	}

	public FactorialThread() {
		super();
	}

	public int getNumber() {
		return number;
	}

	private BigInteger calculateFactorial() {
		BigInteger fact = new BigInteger("1");
		for (int i = 2; i <= number; i++) {
			fact = fact.multiply(new BigInteger("" + i));
		}
		return fact;
	}

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + ": " + number + "! = " + calculateFactorial());
	}
}
