package ru.yandex.sergaidm;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		int[] array = new int[200000];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10);
		}
		MultiThreadSorting.sort(array, 1);
		System.out.println(Arrays.toString(array) + " - MultiThread sort");
	}

}
