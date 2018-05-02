package ru.yandex.sergaidm;

import java.io.File;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		SitesChecker sc = new SitesChecker();
		File file = new File("Addresses.txt");
		sc.loadAddressFromFile(file);
		Map<String, String> sitesList = sc.getSitesList();
		Set<String> address = sitesList.keySet();
		for (String urlAddress : address) {
			System.out.println(urlAddress + "\t" + sitesList.get(urlAddress));
		}

	}
	
}
