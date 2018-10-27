package es.upm.pproject.tdd.exceptions;

public class DuplicatedException extends Exception{
	private static final String MSG = "Error: Duplicated object.";

	public DuplicatedException() {
		super(MSG);
	}
}
