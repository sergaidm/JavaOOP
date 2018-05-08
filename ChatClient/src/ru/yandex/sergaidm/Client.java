package ru.yandex.sergaidm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private String nickName;
	private Socket socket;
	private String serverIP;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private MessageProvider messageProvider = null;
	private MessageRender messageRender = null;
	private Thread listenerThread;
	private Thread senderThread;

	public Client() {
		super();
	}

	private boolean initialization() {
		for (boolean correct = false; correct != true;) {
			try {
				System.out.println("Please input Server IP");
				this.serverIP = br.readLine();
				this.socket = new Socket(serverIP, 20000);
				System.out.println("Input your nickName");
				this.nickName = br.readLine();
				correct = true;
			} catch (UnknownHostException e) {
				System.out.println("Unable to connect. Try another IP");
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		System.out.println("Initialization start");
		MessageProviderImplementation messageProviderImplementation = new MessageProviderImplementation();
		MessageRenderImplementation messageRenderImplementation = new MessageRenderImplementation();
		System.out.println("Set Provider and Render Implementation");
		try {
			messageProviderImplementation.setSocket(this.socket);
			this.messageProvider = messageProviderImplementation;
			this.messageRender = messageRenderImplementation;
		} catch (IOException e) {
			System.out.println(e);
			return false;
		}
		this.listenerThread = new Thread(new ListenerThread(this.messageProvider, this.messageRender));
		this.senderThread = new Thread(new SenderThread(messageProvider, nickName));
		System.out.println("Initialization end");
		return true;
	}

	public void start() {
		boolean startInit = this.initialization();
		if (startInit == false) {
			System.out.println("Initialization failed ...");
			return;
		}
		System.out.println("Chat is running. Input the text and press Enter to send the message");
		listenerThread.start();
		senderThread.start();
		for (; listenerThread.isAlive() && senderThread.isAlive();) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		if (listenerThread.isAlive()) {
			listenerThread.interrupt();
		}
		if (senderThread.isAlive()) {
			senderThread.interrupt();
		}
		try {
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
