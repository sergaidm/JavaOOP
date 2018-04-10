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
		Letter[] letarr = { new Letter("a"), new Letter("b"), new Letter("c"), new Letter("d"), new Letter("e"),
				new Letter("f"), new Letter("g"), new Letter("h"), new Letter("i"), new Letter("j"), new Letter("k"),
				new Letter("l"), new Letter("m"), new Letter("n"), new Letter("o"), new Letter("p"), new Letter("q"),
				new Letter("r"), new Letter("s"), new Letter("t"), new Letter("u"), new Letter("v"), new Letter("w"),
				new Letter("x"), new Letter("y"), new Letter("z") };
		letters = Arrays.asList(letarr);
		Iterator<String> counter = list.iterator();		
		for (int i = 0; i < list.size(); i++) {
			for (; counter.hasNext();) {
				Iterator<Letter> countPosition = letters.iterator();				
				if (counter.next().equalsIgnoreCase(countPosition.next().getLetter())) {
					lettersNumber++;
				}
			}
		}
		System.out.println();
		for (int i = 0; i < letters.size(); i++) {
			letters.sort(letters.get(i));
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
