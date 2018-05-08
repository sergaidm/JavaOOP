package ru.yandex.sergaidm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SingleConnection implements Runnable {

	private MessageProvider messageProvider;
	private ArrayList<SingleConnection> connectionList;
	private List<Message> messageList;
	private int connectionId;

	public SingleConnection(MessageProvider messageProvider, ArrayList<SingleConnection> connectionList,
			List<Message> messageList, int connectionId) {
		super();
		this.messageProvider = messageProvider;
		this.connectionList = connectionList;
		this.connectionId = connectionId;
		this.messageList = messageList;
	}

	public MessageProvider getMessageProvider() {
		return messageProvider;
	}

	private final void addToConnectionList() {
		this.connectionList.add(this);
	}

	private final void deleteFromConnectionList() {
		this.connectionList.remove(this);
	}

	@Override
	public void run() {
		addToConnectionList();
		Thread thread = Thread.currentThread();
		try {
			for (Message messageTemp : messageList) {
				this.messageProvider.sendMessage(messageTemp);
			}
			for (; !thread.isInterrupted();) {
				Message message = this.messageProvider.readMessage();
				if (message == null) {
					throw new IOException();
				}
				if (message != null) {
					messageList.add(message);
				}
				for (SingleConnection singleConnection : connectionList) {
					singleConnection.getMessageProvider().sendMessage(message);
				}
			}
		} catch (IOException e) {
			System.out.println(e);
			deleteFromConnectionList();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + connectionId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SingleConnection other = (SingleConnection) obj;
		if (connectionId != other.connectionId)
			return false;
		return true;
	}

}