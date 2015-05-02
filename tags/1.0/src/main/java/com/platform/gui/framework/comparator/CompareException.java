package com.platform.gui.framework.comparator;

public class CompareException extends RuntimeException {

	private static final long serialVersionUID = -2581394950847531525L;

	public CompareException() {
		super();
	}

	public CompareException(String message) {
		super(message);
	}

	public CompareException(Throwable cause) {
		super(cause);
	}

	public CompareException(String message, Throwable cause) {
		super(message, cause);
	}
}