package es.upm.pproject.tdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import es.upm.pproject.tdd.exceptions.*;


public class EnrollStudentTest {
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
	private void init() throws InvalidInputArgumentException {
		this.students = new ArrayList <Student>();
		this.courses = new ArrayList <Course>();
		this.manager = new Manager(students, courses);
	}
	
	@Test
	public void enroll_student_max_capacity_test() throws NotInTheSystemException, AlreadyInTheSystemException, 
						MaxCapacityException, InvalidInputArgumentException, DuplicatedException {
		String name = Character.toString(rndChar());
		manager.newCourse(1, "Programming Project", "Guillermo");
		for (int i = 1; i <= 51; i++) {
			name.concat(Character.toString(rndChar()));
			manager.newStudent(i, name, "example@test.com");
			manager.enrollStudent(i, 1);
		}
		assertThrows(MaxCapacityException.class, ()->{
	    	  manager.newStudent(52, "Victor Nieves", "victor.nieves@test.com");
	    	  manager.enrollStudent(52, 1);
	        });
	}
	
	@Test
	public void enroll_student_ok_1_test() throws NotInTheSystemException, AlreadyInTheSystemException, 
						MaxCapacityException, InvalidInputArgumentException, DuplicatedException {
		manager.newCourse(1, "Programming Project", "Guillermo");
		manager.newStudent(1, "victor nieves", "example@test.com");
		manager.enrollStudent(1, 1);
		assertEquals(1, courses.get(0).getStudents().size());
		assertEquals(this.students.toString(), courses.get(0).getStudents().toString());
	}
	
	@Test
	public void enroll_student_ok_2_test() throws NotInTheSystemException, AlreadyInTheSystemException, 
						MaxCapacityException, InvalidInputArgumentException, DuplicatedException {
		manager.newCourse(1, "Programming Project", "Guillermo");
		manager.newStudent(1, "victor nieves", "example@test.com");
		manager.enrollStudent(1, 1);
		manager.newStudent(2, "Xavier Robles", "example@test.com");
		manager.enrollStudent(2, 1);
		assertEquals(2, courses.get(0).getStudents().size());
		assertEquals(this.students.toString(), courses.get(0).getStudents().toString());
	}
	
	@Test
	public void enroll_student_ok_3_test() throws NotInTheSystemException, AlreadyInTheSystemException, 
						MaxCapacityException, InvalidInputArgumentException, DuplicatedException {
		String name = Character.toString(rndChar());
		manager.newCourse(1, "Programming Project", "Guillermo");
		for (int i = 1; i <= 26; i++) {
			name.concat(Character.toString(rndChar()));
			manager.newStudent(i, name, "example@test.com");
			manager.enrollStudent(i, 1);
		}
		assertEquals(students.toString(), courses.get(0).getStudents().toString());
	}
	
	@Test
	public void enroll_student_duplicated_student_test() throws NotInTheSystemException, AlreadyInTheSystemException, 
						MaxCapacityException, InvalidInputArgumentException, DuplicatedException{
		manager.newCourse(1, "Programming Project", "Guillermo");
		manager.newStudent(1, "victor nieves", "example@test.com");
		manager.enrollStudent(1, 1);
		assertThrows(AlreadyInTheSystemException.class, ()->{
	    	  manager.enrollStudent(1, 1);
        });
	}
	
	@Test
	public void enroll_student_student_not_in_system_test() throws NotInTheSystemException, AlreadyInTheSystemException,
						MaxCapacityException, InvalidInputArgumentException, DuplicatedException {
		manager.newCourse(1, "Programming Project", "Guillermo");
		assertThrows(NotInTheSystemException.class, ()->{
	    	  manager.enrollStudent(1, 1);
        });
	}
	
	@Test
	public void enroll_student_course_not_in_system_test() throws NotInTheSystemException, AlreadyInTheSystemException, 
						MaxCapacityException, InvalidInputArgumentException, DuplicatedException {
		manager.newStudent(1, "victor nieves", "example@test.com");
		assertThrows(NotInTheSystemException.class, ()->{
	    	  manager.enrollStudent(1, 1);
        });
	}
}