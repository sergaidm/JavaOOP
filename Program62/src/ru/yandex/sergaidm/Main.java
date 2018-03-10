package ru.yandex.sergaidm;

public class Main {
	public static final int THREADS_COUNT = 4;
	public static final int PART_LENGTH = 20_000_000;

	public static void main(String[] args) {

		int[] array = new int[THREADS_COUNT * PART_LENGTH];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 9);
		}

		long tBegin = 0;
		long tEnd = 0;

		tBegin = System.currentTimeMillis();
		System.out.println("Result = " + SumCalculator.multithreadingSumÑalculation(array, THREADS_COUNT, PART_LENGTH));
		tEnd = System.currentTimeMillis();
		System.out.println("Time of multithreading sum calculation: " + (tEnd - tBegin) + " ms");

		tBegin = System.currentTimeMillis();
		System.out.println("Result = " + SumCalculator.simpleSumÑalculation(array));
		tEnd = System.currentTimeMillis();
		System.out.println("Time of simple sum calculation: " + (tEnd - tBegin) + " ms");

	}
}