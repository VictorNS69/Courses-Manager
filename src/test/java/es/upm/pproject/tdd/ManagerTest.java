package es.upm.pproject.tdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ManagerTest {
	private ArrayList <Student> students;
	private ArrayList <Course>courses;
	private Manager manager;
	
	@BeforeEach
	private void init() throws MyException {
		this.students = new ArrayList <Student>();
		this.courses = new ArrayList <Course>();
		this.manager = new Manager(students, courses);
	}

	@Test
	public void manager_null_course_test() throws MyException{
		assertThrows(Exception.class, ()->{
			this.manager = new Manager(this.students, null);
		});
	 }
	  
	 @Test
	 public void manager_null_student_test() throws MyException{
		 assertThrows(Exception.class, ()->{
			 this.manager = new Manager(null, this.courses);
		 });
	}
}
