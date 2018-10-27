package es.upm.pproject.tdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import es.upm.pproject.tdd.exceptions.*;

public class CancelTest {
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
	public void cancel_empty_students_list_test()  {
		assertThrows(Exception.class, ()->{
			this.manager.newCourse(1, "Programming Project", "Guillermo");
			this.manager.cancel(this.students.get(0), this.courses.get(0));
		});
	}
	

	@Test
	public void cancel_empty_courses_list_test(){
		assertThrows(Exception.class, ()->{
			this.manager.newStudent(1, "Victor", "email@test.com");
			this.manager.cancel(this.students.get(0), this.courses.get(0));
		});
	}
	

	@Test
	public void cancel_null_student_test() {
		assertThrows(Exception.class, ()->{
			this.manager.newCourse(1, "Programming Project", "Guillermo");
			this.manager.cancel(null, this.courses.get(0));
		});
	}
	
	@Test
	public void cancel_null_course_test() {
		assertThrows(Exception.class, ()->{
			this.manager.newStudent(1, "Victor", "email@test.com");
			this.manager.cancel(this.students.get(0), null);
		});
	}
	
	@Test
	public void cancel_ok_1_test() throws DuplicatedException, InvalidInputArgumentException,
				NotInTheSystemException, AlreadyInTheSystemException, MaxCapacityException, EmptyListException {
		this.manager.newStudent(1, "Victor", "email@test.com");
		this.manager.newCourse(1, "Programming Project", "Guillermo");
		this.manager.enrollStudent(1, 1);
		this.manager.cancel(this.students.get(0),this.courses.get(0));
		assertEquals(1, this.students.size());
		assertEquals(0,this.courses.get(0).getStudents().size());
	}
	
	@Test
	public void cancel_ok_2_test() throws NotInTheSystemException, AlreadyInTheSystemException, 
				MaxCapacityException, InvalidInputArgumentException, DuplicatedException, EmptyListException {
		this.manager.newStudent(1, "Victor", "email@test.com");
		this.manager.newStudent(2, "Alejandro", "email@test.com");
		this.manager.newCourse(1, "Programming Project", "Guillermo");
		this.manager.enrollStudent(1, 1);
		this.manager.enrollStudent(2, 1);
		this.manager.cancel(this.students.get(0),this.courses.get(0));
		assertEquals(2, this.students.size());
		assertEquals(1,this.courses.get(0).getStudents().size());
	}
	

	@Test
	public void cancel_ok_3_test() throws NotInTheSystemException, AlreadyInTheSystemException,
				MaxCapacityException, InvalidInputArgumentException, DuplicatedException, EmptyListException {
		this.manager.newStudent(1, "Victor", "email@test.com");
		this.manager.newStudent(2, "Alejandro", "email@test.com");
		this.manager.newCourse(1, "Programming Project", "Guillermo");
		this.manager.enrollStudent(1, 1);
		this.manager.enrollStudent(2, 1);
		this.manager.newStudent(3, "Diego", "email@test.com");
		this.manager.newCourse(2, "Maths", "Alexa");
		this.manager.enrollStudent(3,2);
		this.manager.cancel(this.students.get(0),this.courses.get(0));
		assertEquals(3, this.students.size());
		assertEquals(1, this.courses.get(0).getStudents().size());
		this.manager.cancel(this.students.get(1), this.courses.get(1));
		assertEquals(3, this.students.size());
		assertEquals(0, this.courses.get(1).getStudents().size());
	}
	
	@Test
	public void cancel_student_not_in_course_test() {
		assertThrows(Exception.class, ()->{
			this.manager.newCourse(1, "Programming Project", "Guillermo");
			this.manager.cancel(this.students.get(0), this.courses.get(0));
		});
	}
	
	@Test
	public void cancel_course_not_in_system_test() {
		assertThrows(Exception.class, ()->{
			this.manager.newStudent(1, "Victor", "email@test.com");
			this.manager.newCourse(1, "Programming Project", "Guillermo");
			this.manager.cancel(this.students.get(0), this.courses.get(2));
		});
	}
	
	@Test
	public void cancel_student_not_in_system_test() {
		assertThrows(Exception.class, ()->{
			this.manager.newStudent(1, "Victor", "email@test.com");
			this.manager.newCourse(1, "Programming Project", "Guillermo");
			this.manager.cancel(this.students.get(2), this.courses.get(1));
		});
	}
}