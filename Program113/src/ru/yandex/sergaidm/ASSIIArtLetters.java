package ru.yandex.sergaidm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ASSIIArtLetters {

	private List<File> letters = new ArrayList<>();
	private Map<Character, String> artLetters = new HashMap<>();

	public ASSIIArtLetters() {
		super();
	}

	public Map<String, String> getLettersFromFiles() {
		Map<String, String> artLetters = new HashMap<>();
		artLetters.put("h", getASSIIArtLetter("h"));
		artLetters.put("e", getASSIIArtLetter("e"));
		artLetters.put("l", getASSIIArtLetter("l"));
		artLetters.put("o", getASSIIArtLetter("o"));
		return artLetters;
	}

	public String transform(String text) {
		StringBuilder sb = new StringBuilder();
		String letter = "";
		String artLetter = "";
		Set<Map.Entry<String, String>> set = getLettersFromFiles().entrySet();
		String[] simpleChars = text.split("");
		for (String character : simpleChars) {
			for (Map.Entry<String, String> s : set) {
				letter = s.getKey();
				artLetter = s.getValue();
				if (character.equalsIgnoreCase(letter)) {
					character = artLetter;
					sb.append(character);
				} else {
					sb.append("");
				}
			}
		}
		text = sb.toString();
		return text;
	}

	private String getASSIIArtLetter(String letter) {
		File file = new File(letter + ".txt");
		String[][] artLetter = loadLetterFromFile(file);
		StringBuilder sb = new StringBuilder();
		for (String[] rows : artLetter) {
			for (String element : rows) {
				if (element == null) {
					sb.append("");
				} else {
					sb.append(element);
				}
			}
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

	private String[][] loadLetterFromFile(File file) {
		if (!file.exists() || file.isDirectory()) {
			System.out.println("File not found. Returns a zero-size array");
			return new String[0][0];
		}
		int i = 0;
		int j = 0;
		String[][] array = new String[7][6];
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String tempLine = "";
			for (; (tempLine = br.readLine()) != null;) {
				String[] cols = tempLine.split("");
				for (String rows : cols) {
					array[i][j++] = rows;
				}
				i++;
				j = 0;
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return array;
	}

}