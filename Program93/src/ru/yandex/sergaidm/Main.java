package ru.yandex.sergaidm;

import java.io.File;

public class Main {

	public static void main(String[] args) {		
		
		Letter tr = new Letter();
		File file = new File("Text.txt");
		String text = tr.textFromFile(file);
		tr.textToLetters(text);
		tr.lettersCounter(tr.textToLetters(text));
		
	}

}
