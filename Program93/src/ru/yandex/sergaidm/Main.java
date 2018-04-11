package ru.yandex.sergaidm;

import java.io.File;

public class Main {

	public static void main(String[] args) {		
		
		Letter letter = new Letter();
		File file = new File("Text.txt");
		String text = letter.textFromFile(file);
		letter.textToLetters(text);
		letter.lettersCounter(letter.textToLetters(text));
		
	}

}
