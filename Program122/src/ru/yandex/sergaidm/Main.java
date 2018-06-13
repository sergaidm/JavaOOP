package ru.yandex.sergaidm;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	
	public static void main(String[] args) {

		String answer = Client.getSystemInfo();
		try (ServerSocket ss = new ServerSocket(1000)) {
			int number = 0;
			for (;;) {				
				Socket socket = ss.accept();
				Client client = new Client(socket, answer + "Number of requests: " + ++number);
			}
		} catch (IOException e) {
			e.printStackTrace();	
		}

	}
	
}
