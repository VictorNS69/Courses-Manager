package es.upm.pproject.tdd;

import org.junit.jupiter.api.*;
import es.upm.pproject.tdd.exceptions.*;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ManagerTest {
	private ArrayList <Student> students;
	private ArrayList <Course>courses;
	private Manager manager;
	
	@BeforeEach
	private void init() throws InvalidInputArgumentException {
		this.students = new ArrayList <Student>();
		this.courses = new ArrayList <Course>();
		this.manager = new Manager(students, courses);
	}

	@Test
	public void manager_null_course_test() throws InvalidInputArgumentException{
		assertThrows(InvalidInputArgumentException.class, ()->{
			this.manager = new Manager(this.students, null);
		});
	 }
	  
	 @Test
	 public void manager_null_student_test() throws InvalidInputArgumentException{
		 assertThrows(InvalidInputArgumentException.class, ()->{
			 this.manager = new Manager(null, this.courses);
		 });
	}
}
