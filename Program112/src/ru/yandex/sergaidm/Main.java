package ru.yandex.sergaidm;

import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Objects<Long> arrayOne = new Objects<>(12);
		arrayOne.addObjectToArray(1L);
		arrayOne.addObjectToArray(1L);
		arrayOne.addObjectToArray(1L);
		arrayOne.addObjectToArray(1L);
		arrayOne.addObjectToArray(2L);
		arrayOne.addObjectToArray(3L);
		arrayOne.addObjectToArray(4L);
		arrayOne.addObjectToArray(5L);
		arrayOne.addObjectToArray(5L);
		arrayOne.addObjectToArray(4L);
		arrayOne.addObjectToArray(4L);
		arrayOne.addObjectToArray(2L);
		System.out.println("Array of objects of 'Long' type:");
		arrayOne.printArray(arrayOne);
		System.out.println();
		Counter<Long> counterOne = new Counter<>();
		Map<Long, Integer> mapOne = counterOne.count(arrayOne);
		System.out.println("Number of repeats of objects in array of 'Long' type:");
		mapOne.forEach((key, value) -> System.out.println("The object '" + key + "' repeats " + value + " times"));

		System.out.println();

		Objects<Double> arrayTwo = new Objects<>(8);
		arrayTwo.addObjectToArray(1.0);
		arrayTwo.addObjectToArray(1.0);
		arrayTwo.addObjectToArray(1.0);
		arrayTwo.addObjectToArray(2.0);
		arrayTwo.addObjectToArray(3.0);
		arrayTwo.addObjectToArray(4.0);
		arrayTwo.addObjectToArray(3.0);
		arrayTwo.addObjectToArray(2.0);
		System.out.println("Array of objects of 'Double' type:");
		arrayTwo.printArray(arrayTwo);
		System.out.println();
		Counter<Double> counterTwo = new Counter<>();
		Map<Double, Integer> mapTwo = counterTwo.count(arrayTwo);
		System.out.println("Number of repeats of objects in array of 'Double' type:");
		mapTwo.forEach((key, value) -> System.out.println("The object '" + key + "' repeats " + value + " times"));

		System.out.println();

		Objects<String> arrayThree = new Objects<>(6);
		arrayThree.addObjectToArray("Ivanov");
		arrayThree.addObjectToArray("Petrov");
		arrayThree.addObjectToArray("Sidorov");
		arrayThree.addObjectToArray("Sidorov");
		arrayThree.addObjectToArray("Sidorov");
		arrayThree.addObjectToArray("Ivanov");
		System.out.println("Array of objects of 'String' type:");
		arrayThree.printArray(arrayThree);
		System.out.println();
		Counter<String> counterThree = new Counter<>();
		Map<String, Integer> mapThree = counterThree.count(arrayThree);
		System.out.println("Number of repeats of objects in array of 'String' type:");
		mapThree.forEach((key, value) -> System.out.println("The object '" + key + "' repeats " + value + " times"));
	}

}
