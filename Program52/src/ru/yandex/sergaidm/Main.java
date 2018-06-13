package ru.yandex.sergaidm;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		FileOperations.saveSameWords(new File("FileOne.txt"),  new File("FileTwo.txt"), new File("FileThree.txt"));
		
	}
}
