package ru.yandex.sergaidm;

/*Create a program that accepts two text files and returns one.
 * This file must contain words that are simultaneously in both the first and second file.*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		File one = new File("1.txt");
		File two = new File("2.txt");
		File three = new File("3.txt");
		String textOne = textFromFile(one);
		String textTwo = textFromFile(two);
		String[] tOne = textOne.split(" ");
		String[] tTwo = textTwo.split(" ");
		String text = sameWords(tOne, tTwo);
		System.out.println(text);

		try (PrintWriter pw = new PrintWriter(three)) {
			pw.println(text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

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
}
