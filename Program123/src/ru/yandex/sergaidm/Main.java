package ru.yandex.sergaidm;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		HtmlParser htmlParser = new HtmlParser("https://prog.kiev.ua/forum/", new File("Links.txt"));
		htmlParser.getURLLinks();

	}

}
