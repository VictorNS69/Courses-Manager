package es.upm.pproject.tdd.exceptions;

public class NotInTheSystemException extends Exception{
	private static final String MSG = "Error: Not in the system.";

	public NotInTheSystemException() {
		super(MSG);
	}
}
