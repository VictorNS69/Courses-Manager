package es.upm.pproject.tdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ListCoursesTest{
	private List <Student> students;
	private List <Course> courses;
	private Manager manager;

	@BeforeEach
	private void init() throws MyException {
		this.students = new ArrayList <Student>();
		this.courses = new ArrayList <Course>();
		this.manager = new Manager(students, courses);
	}

	@Test
	public void list_courses_empty_test() {
		List <Course> c = manager.listCourses();
		assertEquals(this.courses.toString(), c.toString());
	}

	@Test
	public void list_courses_ok_1_test() throws MyException {
		manager.newCourse(1, "Programming Project", "Guillermo");
		List <Course> c = manager.listCourses();
		assertEquals(this.courses.toString(), c.toString());
	}

	@Test
	public void list_courses_ok_2_test() throws MyException{
		for (int i=1; i < 30;i++) {
			manager.newCourse(i, "name", "coordinator");
		}
		List <Course> c = manager.listCourses();
		assertEquals(this.courses.toString(), c.toString());
	}
}