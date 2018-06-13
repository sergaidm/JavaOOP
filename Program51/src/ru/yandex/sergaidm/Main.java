package ru.yandex.sergaidm;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		FileFilterImplementation ffi = new FileFilterImplementation("txt");
		File folderSource = new File("folderSource");
		File folderReceiver = new File("folderReceiver");
		try {
			FileOperation.folderCopy(folderSource, folderReceiver, ffi);
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("Files from folder are copied to the new folder.");

	}

}
