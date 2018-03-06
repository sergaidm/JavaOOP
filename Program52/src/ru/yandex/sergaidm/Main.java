package ru.yandex.sergaidm;

/*Create a program that accepts two text files and returns one.
 * This file must contain words that are simultaneously in both the first and second file.*/

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File fileOne = new File("1.txt");
		File fileTwo = new File("2.txt");
		File fileThree = new File("3.txt");
		String textOne = FileOperations.textFromFile(fileOne);
		String textTwo = FileOperations.textFromFile(fileTwo);
		String[] tOne = textOne.split(" ");
		String[] tTwo = textTwo.split(" ");
		String text = FileOperations.sameWords(tOne, tTwo);
		System.out.println(text);
		FileOperations.saveToFile(text, fileThree);
	}
}
