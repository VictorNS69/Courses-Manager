package es.upm.pproject.tdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import es.upm.pproject.tdd.exceptions.*;

public class ListCoursesTest{
	private List <Student> students;
	private List <Course> courses;
	private Manager manager;

	@BeforeEach
	private void init() throws InvalidInputArgumentException {
		this.students = new ArrayList <Student>();
		this.courses = new ArrayList <Course>();
		this.manager = new Manager(students, courses);
	}

	@Test
	public void listCoursesEmptyTest() {
		List <Course> c = manager.listCourses();
		assertEquals(this.courses.toString(), c.toString());
	}

	@Test
	public void listCoursesOk1Test() throws InvalidInputArgumentException, DuplicatedException {
		manager.newCourse(1, "Programming Project", "Guillermo");
		List <Course> c = manager.listCourses();
		assertEquals(this.courses.toString(), c.toString());
	}

	@Test
	public void listCoursesOk2Test() throws InvalidInputArgumentException, DuplicatedException{
		for (int i=1; i < 30;i++) {
			manager.newCourse(i, "name", "coordinator");
		}
		List <Course> c = manager.listCourses();
		assertEquals(this.courses.toString(), c.toString());
	}
}