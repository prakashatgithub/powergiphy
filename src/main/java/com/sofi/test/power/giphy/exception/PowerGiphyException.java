package com.sofi.test.power.giphy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PowerGiphyException extends RuntimeException {

	/**
	 * Generated id.
	 */
	private static final long serialVersionUID = -4233967408113059473L;

	public PowerGiphyException(String message) {
		super(message);
	}

	public PowerGiphyException(String message, Throwable cause) {
		super(message, cause);
	}
}
