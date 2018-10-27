package es.upm.pproject.tdd.exceptions;

public class MaxCapacityException extends Exception{
	private static final String MSG = "Error: Max capacity reached.";

	public MaxCapacityException() {
		super(MSG);
	}
}
