package es.upm.pproject.tdd.exceptions;

public class EmptyListException extends Exception{
	private static final String MSG = "Error: Empty list.";

	public EmptyListException() {
		super(MSG);
	}
}
