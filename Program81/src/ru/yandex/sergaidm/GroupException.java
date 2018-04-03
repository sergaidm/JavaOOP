package ru.yandex.sergaidm;

import java.io.Serializable;

public class GroupException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

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
