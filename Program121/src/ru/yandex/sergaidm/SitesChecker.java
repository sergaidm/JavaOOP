package ru.yandex.sergaidm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SitesChecker {

	private Map<String, String> sites = new HashMap<>();

	public SitesChecker() {
		super();
	}

	public void loadAddressFromFile(File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String urlAddress = "";
			for (; (urlAddress = br.readLine()) != null;) {
				if (!sites.containsKey(urlAddress)) {
					sites.put(urlAddress, checkOneSite(urlAddress));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Map<String, String> getSitesList() {
		return this.sites;
	}

	public String checkOneSite(String urlAddress) {
		try {
			URL url = new URL(urlAddress);
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			int responseCode = connect.getResponseCode();
			if (responseCode >= 200 && responseCode < 300) {
				return "Site is available";
			} else {
				return "Site unavailable" + connect.getResponseMessage();
			}
		} catch (IOException e) {
			return "A web address does not exist";
		}
	}

}
