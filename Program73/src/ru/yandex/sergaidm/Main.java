package ru.yandex.sergaidm;

public class Main {

	public static void main(String[] args) {

		System.out.println("Find files by part of name:");
		String target = "mp3";
		String folder = "E:\\����\\1991 - ����� �� �����";
		FileSeacher.findFile(target, folder, false);

		System.out.println("Find files by name:");
		target = "05. ����� �� �����.mp3";
		folder = "E:\\����\\1991 - ����� �� �����";
		FileSeacher.findFile(target, folder);

	}

}
