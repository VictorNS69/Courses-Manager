package es.upm.pproject.tdd;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
	if (args.length == 1)
	        System.out.println( "Hello World!" );
	else if (args.length == 0)
		System.out.println("No arguments, no hello.");	
	else
		System.out.println("Too many arguments!");
    }
}
