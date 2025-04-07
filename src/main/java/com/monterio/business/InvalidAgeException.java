package com.monterio.business;

public class InvalidAgeException extends Exception {

	public static final String INVALID_AGE_MSG = "Customer age must be between 18 and 65.";

	public InvalidAgeException(String message) {
		super(message);
	}
}