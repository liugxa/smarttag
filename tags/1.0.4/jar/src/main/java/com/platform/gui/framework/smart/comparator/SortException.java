package com.platform.gui.framework.smart.comparator;

public class SortException extends RuntimeException {

    private static final long serialVersionUID = 2148595327816511306L;

	public SortException() {
		super();
	}

	public SortException(String message) {
		super(message);
	}

	public SortException(Throwable cause) {
		super(cause);
	}

	public SortException(String message, Throwable cause) {
		super(message, cause);
	}
}
