package ru.yandex.sergaidm;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		String string = "This string will be presented in ASSII-format";
		System.out.println(Arrays.toString(stringToASSIIArray(string)));
	}

	public static int[] stringToASSIIArray(String text) {
		return text.chars().toArray();
	}

}
