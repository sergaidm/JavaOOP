package ru.yandex.sergaidm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Letter {

	private String letter;
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
		int[] repeats = new int[26];
		Letter[] lettersArray = { new Letter("a"), new Letter("b"), new Letter("c"), new Letter("d"), new Letter("e"),
				new Letter("f"), new Letter("g"), new Letter("h"), new Letter("i"), new Letter("j"), new Letter("k"),
				new Letter("l"), new Letter("m"), new Letter("n"), new Letter("o"), new Letter("p"), new Letter("q"),
				new Letter("r"), new Letter("s"), new Letter("t"), new Letter("u"), new Letter("v"), new Letter("w"),
				new Letter("x"), new Letter("y"), new Letter("z") };
		letters = Arrays.asList(lettersArray);
		System.out.println("Number of repeats of letters in the text: ");
		for (String string : list) {
			for (int i = 0; i < repeats.length; i++) {
				if (string.equalsIgnoreCase(letters.get(i).getLetter())) {
					repeats[i]++;
				}
			}
		}
		Map<Integer, Letter> map = new TreeMap<>(comparator);
		for (int i = 0; i < letters.size(); i++) {
			map.put(repeats[i], letters.get(i));
		}
		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			System.out.println("The letter '" + map.get(key) + "' repeat " + key + " times in the text");
		}
	}

	Comparator<Integer> comparator = new Comparator<Integer>() {
		@Override
		public int compare(Integer a, Integer b) {
			if (a > b) {
				return -1;
			} else if (a < b) {
				return 1;
			} else {
				return 0;
			}
		}
	};

	@Override
	public String toString() {
		return letter;
	}

}
