package ru.yandex.sergaidm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		System.out.println("The maximum number of text file numbers: " + maxNumberFromFile());
	}

	public static int maxNumberFromFile() {
		int max = 0;
		try {
			max = Files.lines(Paths.get("Text.txt"))
					.map(n -> n.replaceAll("[,.]", ""))
					.flatMapToInt(n -> Stream.of(n.split(" "))
					.mapToInt(m -> Integer.parseInt(m))).max().getAsInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return max;
	}
}
