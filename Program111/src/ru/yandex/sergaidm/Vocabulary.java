package ru.yandex.sergaidm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class Vocabulary implements Serializable {

	private static final long serialVersionUID = 1L;
	private NavigableMap<String, String> vocabulary = new TreeMap<>();
	private Set<Entry<String, String>> set = new HashSet<>();

	public Vocabulary() {
		super();
	}

	public Set<Entry<String, String>> entrySet() {
		return vocabulary.entrySet();
	}

	public String getEnglishWord() {
		String englishWord = "";
		Set<Map.Entry<String, String>> set = vocabulary.entrySet();
		for (Map.Entry<String, String> s : set) {
			englishWord = s.getKey();
		}
		return englishWord;
	}

	public String setRussianWord() {
		String russianWord = "";
		Set<Map.Entry<String, String>> set = vocabulary.entrySet();
		for (Map.Entry<String, String> s : set) {
			russianWord = s.getValue();
		}
		return russianWord;
	}

	public void addingWordToVocabulary(String englishWord, String russianWord) {
		Map.Entry<String, String> word = new Entry<String, String>() {

			@Override
			public String getKey() {
				return englishWord;
			}

			@Override
			public String getValue() {
				return russianWord;
			}

			@Override
			public String setValue(String value) {
				value = russianWord;
				return value;
			}
		};
		vocabulary.putIfAbsent(word.getKey(), word.getValue());
	}

	public void printVocabulary() {
		vocabulary.forEach((englishWord, russianWord) -> System.out.println(englishWord + " -> " + russianWord));
	}
		
	public void loadWords(File file) {		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] array = line.split("[ -> ]");
				String englishWord = array[0];
				String russianWord = array[array.length-1];
				NavigableMap<String, String> words = new TreeMap<>();
				words.put(englishWord, russianWord);				
				vocabulary.putAll(words);				 
			}	
			vocabulary.remove("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveVocabulary() {
		File file = new File("Vocabulary.txt");		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(set);
		} catch (IOException e) {
			System.out.println("Vocabulary save error");
		}
	}	
	
	public void loadVocabulary() {
		File file = new File("Vocabulary.txt");
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			set = (HashSet<Entry<String, String>>) ois.readObject();			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Vocabulary load error");
		}		
		for (Entry<String, String> entry : set) {
			String englishWord = entry.getKey();
			String russianWord = entry.getValue();
			vocabulary.put(englishWord, russianWord);
		}		
	}

}
