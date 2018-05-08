package ru.yandex.sergaidm;

import java.io.IOException;

public class ListenerThread implements Runnable {

	private MessageProvider messageProvider;
	private MessageRender messageRender;

	public ListenerThread(MessageProvider messageProvider, MessageRender messageRender) {
		super();
		this.messageProvider = messageProvider;
		this.messageRender = messageRender;
	}

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		try {
			for (; !thread.isInterrupted();) {
				Message message = messageProvider.readMessage();
				messageRender.renderMessage(message);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("ListenerThread is shutdown");
	}

}