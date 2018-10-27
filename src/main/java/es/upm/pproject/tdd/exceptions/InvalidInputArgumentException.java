package es.upm.pproject.tdd.exceptions;

public class InvalidInputArgumentException extends Exception{
	private static final String MSG = "Error: Invalid input argument.";

	public InvalidInputArgumentException() {
		super(MSG);
	}
}
