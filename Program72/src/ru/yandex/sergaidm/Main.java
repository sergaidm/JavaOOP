package ru.yandex.sergaidm;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		File from = new File("E:\\����\\���� - XX ���.avi");
		File to = new File("F:\\���� - XX ���.avi");
		FileUtils.fileCopy(from, to);

	}
	
}