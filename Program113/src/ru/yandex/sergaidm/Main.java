package ru.yandex.sergaidm;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		ASSIIArtLetters as = new ASSIIArtLetters();
		Scanner sc = new Scanner(System.in);
		System.out.println("Input text: ");
		String text = as.transform(sc.nextLine());
		System.out.println(text);
		
	}

}
