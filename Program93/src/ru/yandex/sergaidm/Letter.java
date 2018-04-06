package ru.yandex.sergaidm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Letter implements Comparator<Letter> {

	private String letter;
	private int lettersNumber;
	private List<String> list;
	private List<Letter> letters;

	public Letter(String letter) {
		super();
		this.letter = letter;
		list = new ArrayList<>();
	}

	public Letter() {
		super();
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public int getLettersNumber() {
		return lettersNumber;
	}

	public String textFromFile(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				sb.append(text);
				sb.append(System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return sb.toString();
	}

	public List<String> textToLetters(String text) {
		list = new ArrayList<>(Arrays.asList(text.split("")));
		return list;
	}

	public void lettersCounter(List<String> list) {
		letters = new ArrayList<>();
		Letter a = new Letter("a");
		Letter b = new Letter("b");
		Letter c = new Letter("c");
		Letter d = new Letter("d");
		Letter e = new Letter("e");
		letters.add(a);
		letters.add(b);
		letters.add(c);
		letters.add(d);
		letters.add(e);
		Iterator<Letter> countPosition = letters.iterator();
		Iterator<String> counter = list.iterator();
		for (int i = 0; i < letters.size(); i++) {
			System.out.print(countPosition.next().getLetter());
			for (; counter.hasNext();) {
				if (counter.next().equalsIgnoreCase(countPosition.next().getLetter())) {
					lettersNumber++;
				}
			}			
		}
		for (int i = 0; i < letters.size(); i++) {
			letters.sort(c);
			System.out.println(
					"The letter '" + letters.get(i).getLetter() + "' repeat " + lettersNumber + " times in the text");
		}
	}

	@Override
	public int compare(Letter a, Letter b) {
		if (a.getLettersNumber() > b.getLettersNumber()) {
			return 1;
		} else if (a.getLettersNumber() < b.getLettersNumber()) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Letter: letter = " + letter;
	}

}
