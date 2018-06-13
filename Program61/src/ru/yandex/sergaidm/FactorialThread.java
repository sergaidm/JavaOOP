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
		BigInteger factorial = new BigInteger("1");
		for (int i = 2; i <= number; i++) {
			factorial = factorial.multiply(new BigInteger("" + i));
		}
		return factorial;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": " + this.number + "! = " + this.calculateFactorial());
	}

}
