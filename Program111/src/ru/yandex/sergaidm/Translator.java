package ru.yandex.sergaidm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class Translator {

	private Vocabulary vocabulary;

	public Translator(Vocabulary vocabulary) {
		super();
		this.vocabulary = vocabulary;
	}

	public Translator() {
		super();
	}

	private String textFromFile(File in) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(in))) {
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

	private String translator(String translation) {		
		translation = translation.replaceAll("[!?,.:;-]", "");
		translation = translation.replace(System.lineSeparator(), " ");
		String[] s = translation.split(" ");
		Set<Map.Entry<String, String>> set = vocabulary.entrySet();
		for (int i = 0; i < s.length; i++) {
			for (Map.Entry<String, String> str : set) {
				if (s[i].equalsIgnoreCase(str.getKey())) {
					s[i] = str.getValue();
				}
			}
		}
		translation = Arrays.toString(s);
		translation = translation.substring(1, translation.length() - 1);
		translation = translation.replace(",", "");
		return translation;
	}

	public void translationToFile(File in, File out) {
		String translation = translator(textFromFile(in));
		try (PrintWriter pw = new PrintWriter(out)) {
			pw.println(translation);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
