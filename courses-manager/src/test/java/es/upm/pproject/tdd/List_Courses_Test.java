package es.upm.pproject.tdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class List_Courses_Test{
	private ArrayList <Student> students;
	private ArrayList <Course> courses;
	private Manager manager;

	@BeforeEach
	private void init() throws MyException {
		this.students = new ArrayList <Student>();
		this.courses = new ArrayList <Course>();
		this.manager = new Manager(students, courses);
	}

	@Test
	public void list_courses_empty_test() {
		ArrayList <Course> c = manager.list_courses();
		assertEquals(this.courses.toString(), c.toString());
	}

	@Test
	public void list_courses_ok_1_test() throws MyException {
		manager.new_course(1, "Programming Project", "Guillermo");
		ArrayList <Course> c = manager.list_courses();
		assertEquals(this.courses.toString(), c.toString());
	}

	@Test
	public void list_courses_ok_2_test() throws MyException{
		for (int i=1; i < 30;i++) {
			manager.new_course(i, "name", "coordinator");
		}
		ArrayList <Course> c = manager.list_courses();
		assertEquals(this.courses.toString(), c.toString());
	}

	@Test
	public void list_courses_null_c_test() throws MyException{
		assertThrows(Exception.class, ()->{
			this.manager = new Manager(this.students, null);
			manager.new_course(1, "Programming Project", "Guillermo");
			ArrayList <Course> c = manager.list_courses();
		});
	}

	@Test
	public void list_courses_null_s_test() throws MyException{
		assertThrows(Exception.class, ()->{
			this.manager = new Manager(null, this.courses);
			manager.new_course(1, "Programming Project", "Guillermo");
			ArrayList <Course> c = manager.list_courses();
		});
	}
}