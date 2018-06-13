package ru.yandex.sergaidm;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		ConsoleTranslator consoleTranslator = new ConsoleTranslator();
		File font = new File("Big letters.txt");
		consoleTranslator.loadFontFromFile(font);
		font = new File("Small letters.txt");
		consoleTranslator.loadFontFromFile(font);
		font = new File("Punctuation marks.txt");
		consoleTranslator.loadFontFromFile(font);
		Scanner sc = new Scanner(System.in);
		System.out.println("Input text to convert to ASSII-art: ");
		String text = sc.nextLine();
		sc.close();
		System.out.println(consoleTranslator.transform(text));

	}

}
