package ru.yandex.sergaidm;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Integer[] array = new Integer[20];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (-30 + Math.random() * 60);
		}
		System.out.println(Arrays.toString(array));
		System.out.println(nearestNumberToZero(array));
	}

	public static int nearestNumberToZero(Integer[] array) {
		return Arrays.stream(array).min((a, b) -> {
			if ((Math.abs(a) == Math.abs(b)) && (b > 0)) {
				return 1;
			}
			return Integer.compare(Math.abs(a), Math.abs(b));
		}).get();
	}
}
