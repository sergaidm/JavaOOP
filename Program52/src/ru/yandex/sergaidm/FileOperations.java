package ru.yandex.sergaidm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class FileOperations {

	public static String textFromFile(File file) throws IOException {
		String text = "";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			for (; (text = br.readLine()) != null;) {
				return text;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return text;
	}

	public static String sameWords(String[] a, String[] b) {
		StringBuilder sb = new StringBuilder();
		String[] copy = Arrays.copyOf(a, b.length);
		for (String word : b) {
			for (int i = 0; i < copy.length; i++) {
				if (word.equals(copy[i])) {
					sb.append(word + " ");
					copy[i] = "";
					break;
				}
			}
		}
		return sb.toString();
	}

	public static void saveToFile(String text, File file) {
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Same words from two files saved to specified file");
	}

}
