package ru.yandex.sergaidm;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		File file = new File(".");
		FileWatcher fw = new FileWatcher(file);
		fw.startFileWatcher();
		
	}
}
