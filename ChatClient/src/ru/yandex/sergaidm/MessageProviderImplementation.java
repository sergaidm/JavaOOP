package ru.yandex.sergaidm;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MessageProviderImplementation implements MessageProvider {
	
	private Socket socket;
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;

	public MessageProviderImplementation(Socket socket) {
		super();
		this.socket = socket;
	}

	public MessageProviderImplementation() {
		super();
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) throws IOException {
		this.socket = socket;
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());
	}

	@Override
	public void sendMessage(Message message) throws IOException {
		try {
			oos.writeObject(message);
		} catch (IOException e) {
			closeStream();
			throw e;
		}
	}

	@Override
	public Message readMessage() throws IOException {
		try {
			return (Message) ois.readObject();
		} catch (ClassNotFoundException e) {
			return null;
		} catch (IOException e) {
			closeStream();
			throw e;
		}
	}

	private final void closeStream() {
		try {
			oos.close();
			ois.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}