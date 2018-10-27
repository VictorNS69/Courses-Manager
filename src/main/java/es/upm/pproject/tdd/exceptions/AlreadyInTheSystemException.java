package es.upm.pproject.tdd.exceptions;

public class AlreadyInTheSystemException extends Exception{
	private static final String MSG = "Error: Already in the system.";

	public AlreadyInTheSystemException() {
		super(MSG);
	}
}
