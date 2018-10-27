package es.upm.pproject.tdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class Enroll_Student_Test {
	private ArrayList <Student> students;
	private ArrayList <Course>courses;
	private Manager manager;
	
	/** Returns a random character from a to z and A to Z.
	 * @return char
	 */
	private static char rndChar () {
	    int rnd = (int) (Math.random() * 52); 
	    char base = (rnd < 26) ? 'A' : 'a';
	    return (char) (base + rnd % 26);
	}
	
	@BeforeEach
	private void init() throws MyException {
		this.students = new ArrayList <Student>();
		this.courses = new ArrayList <Course>();
		this.manager = new Manager(students, courses);
	}
	
	@Test
	public void enroll_student_max_capacity_test() throws MyException {
		String name = Character.toString(rndChar());
		manager.new_course(1, "Programming Project", "Guillermo");
		for (int i = 1; i <= 51; i++) {
			name.concat(Character.toString(rndChar()));
			manager.new_student(i, name, "example@test.com");
			manager.enroll_student(i, 1);
		}
		assertThrows(MyException.class, ()->{
	    	  manager.new_student(52, "Victor Nieves", "victor.nieves@test.com");
	    	  manager.enroll_student(52, 1);
	        });
	}
	
	@Test
	public void enroll_student_ok_1_test() throws MyException {
		manager.new_course(1, "Programming Project", "Guillermo");
		manager.new_student(1, "victor nieves", "example@test.com");
		manager.enroll_student(1, 1);
		assertEquals(1, courses.get(0).getStudents().size());
		assertEquals(this.students.toString(), courses.get(0).getStudents().toString());
	}
	
	@Test
	public void enroll_student_ok_2_test() throws MyException {
		manager.new_course(1, "Programming Project", "Guillermo");
		manager.new_student(1, "victor nieves", "example@test.com");
		manager.enroll_student(1, 1);
		manager.new_student(2, "Xavier Robles", "example@test.com");
		manager.enroll_student(2, 1);
		assertEquals(2, courses.get(0).getStudents().size());
		assertEquals(this.students.toString(), courses.get(0).getStudents().toString());
	}
	
	@Test
	public void enroll_student_ok_3_test() throws MyException {
		String name = Character.toString(rndChar());
		manager.new_course(1, "Programming Project", "Guillermo");
		for (int i = 1; i <= 26; i++) {
			name.concat(Character.toString(rndChar()));
			manager.new_student(i, name, "example@test.com");
			manager.enroll_student(i, 1);
		}
		assertEquals(students.toString(), courses.get(0).getStudents().toString());
	}
	
	@Test
	public void enroll_student_duplicated_student_test() throws MyException{
		manager.new_course(1, "Programming Project", "Guillermo");
		manager.new_student(1, "victor nieves", "example@test.com");
		manager.enroll_student(1, 1);
		assertThrows(MyException.class, ()->{
	    	  manager.enroll_student(1, 1);
	        });
	}
	
	@Test
	public void enroll_student_student_not_in_system_test() throws MyException {
		manager.new_course(1, "Programming Project", "Guillermo");
		assertThrows(MyException.class, ()->{
	    	  manager.enroll_student(1, 1);
	        });
	}
	
	@Test
	public void enroll_student_course_not_in_system_test() throws MyException {
		manager.new_student(1, "victor nieves", "example@test.com");
		assertThrows(MyException.class, ()->{
	    	  manager.enroll_student(1, 1);
	        });
	}
}