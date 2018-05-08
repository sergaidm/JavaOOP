package ru.yandex.sergaidm;

import java.io.IOException;

public interface MessageProvider {
	
	public void sendMessage(Message message) throws IOException;

	public Message readMessage() throws IOException;
	
}