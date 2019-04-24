package com.dimag.text;

public class TextProcessorException extends Exception {

	public TextProcessorException() {
		super();
	}

	public TextProcessorException(String message) {
		super(message);
	}

	public TextProcessorException(String message, Throwable cause) {
		super(message, cause);
	}

	public TextProcessorException(Throwable cause) {
		super(cause);
	}

	protected TextProcessorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
