package ru.yandex.sergaidm;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		Counter letter = new Counter();
		letter.lettersCounter(letter.textToLetters(letter.textFromFile(new File("Text.txt"))));

	}

}
