package ru.yandex.sergaidm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOperations {

	private static String textFromFile(File file) throws IOException {
		if (file == null) {
			throw new IllegalArgumentException("Empty file pointer");
		}
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				sb.append(text);
				sb.append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	private static String[] getWords(String textline) {
		String[] words = textline.split("[ .,\n!]");
		return words;
	}

	private static boolean isWordsInText(String word, String text) {
		String[] textArray = getWords(text);
		for (String wordOne : textArray) {
			if (word.equals(wordOne)) {
				return true;
			}
		}
		return false;
	}

	public static void saveToFile(String text, File file) {
		if (file == null || text == null) {
			throw new IllegalArgumentException("Empty file pointer");
		}
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void saveSameWords(File fileOne, File fileTwo, File fileThree) throws IOException {
		if (fileOne == null || fileTwo == null || fileThree == null) {
			throw new IllegalArgumentException("Empty file pointer");
		}
		String textOne = textFromFile(fileOne);
		String textTwo = textFromFile(fileTwo);
		StringBuilder sb = new StringBuilder();
		String[] words = getWords(textOne);
		for (String word : words) {
			if (isWordsInText(word, textTwo)) {
				sb.append(word + " ");
			}
		}
		saveToFile(sb.toString(), fileThree);
	}

}
