package ru.yandex.sergaidm;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		File from = new File("E:\\Ария\\Ария - XX лет.avi");
		File to = new File("F:\\Ария - XX лет.avi");
		FileUtils.fileCopy(from, to);

	}
	
}