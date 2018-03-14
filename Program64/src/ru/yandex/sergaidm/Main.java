package ru.yandex.sergaidm;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		File folderSource = new File("Source");
		folderSource.mkdir();
		FileOperations.createFiles(folderSource, 100);
		FileOperations.multithreadingCopyingFiles(folderSource, 100);

	}

}
