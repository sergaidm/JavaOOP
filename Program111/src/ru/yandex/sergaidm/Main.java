package ru.yandex.sergaidm;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		File in = new File("English.in");
		File out = new File("Russian.out");
		File words = new File("Words.txt");
		Vocabulary engRusVocabulary = new Vocabulary();
		Translator translator = new Translator(engRusVocabulary);
		engRusVocabulary.loadWords(words);

		engRusVocabulary.addingWordToVocabulary("university", "университет");
		engRusVocabulary.addingWordToVocabulary("school", "школа");
		engRusVocabulary.addingWordToVocabulary("window", "окно");

		engRusVocabulary.saveVocabulary();
		System.out.println("Vocabulary saved in file 'Vocabulary.txt'");
		System.out.println();
		engRusVocabulary.loadVocabulary();
		engRusVocabulary.printVocabulary();

		translator.translationToFile(in, out);
		System.out.println(System.lineSeparator() + "Translation of text from file 'English.in' saved in file 'Russian.out'");

	}

}
