package ru.yandex.sergaidm;

public class GroupException extends Exception {

	public GroupException() {
		super();
	}

	public GroupException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GroupException(String message, Throwable cause) {
		super(message, cause);
	}

	public GroupException(String message) {
		super(message);
	}

	public GroupException(Throwable cause) {
		super(cause);
	}
	
}
