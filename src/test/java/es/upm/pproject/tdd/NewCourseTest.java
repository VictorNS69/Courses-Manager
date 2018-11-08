package es.upm.pproject.tdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import es.upm.pproject.tdd.exceptions.*;

public class NewCourseTest{
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
	public void newCourseOkEmptyList1Test() throws InvalidInputArgumentException, DuplicatedException{
		manager.newCourse(1, "Programming Project", "Guillermo");
		assertEquals(1, this.courses.size());
		Course c = new Course(1, "Programming Project", "Guillermo");
		assertEquals (c.toString(), this.courses.get(0).toString());
	}

	@Test
	public void newCourseOkNotEmptyList2Test() throws InvalidInputArgumentException, DuplicatedException{
		manager.newCourse(1, "Programming Project", "Guillermo");
		manager.newCourse(2, "Math", "Luisa");
		assertEquals(2, this.courses.size());
		Course c1 = new Course(1, "Programming Project", "Guillermo");
		Course c2 = new Course(2, "Math", "Luisa");
		assertEquals (c1.toString(), this.courses.get(0).toString());
		assertEquals (c2.toString(), this.courses.get(1).toString());
	}

	@Test
	public void newCourseOkNotEmptyList3Test() throws InvalidInputArgumentException, DuplicatedException{
		manager.newCourse(2, "Programming Project", "Guillermo");
		manager.newCourse(1, "Math", "Luisa");
		assertEquals(2, this.courses.size());
		Course c2 = new Course(1, "Math", "Luisa");
		Course c1 = new Course(2, "Programming Project", "Guillermo");
		assertEquals (c2.toString(), this.courses.get(0).toString());
		assertEquals (c1.toString(), this.courses.get(1).toString());
	}

	@Test
	public void newCourseDuplicatedTest() {
		assertThrows(DuplicatedException.class, ()->{
			manager.newCourse(1, "Programming Project", "Guillermo");
			manager.newCourse(1, "Math", "Luisa");
		});
	}

	@Test
	public void newCourseCodeBlankTest (){
		assertThrows(InvalidInputArgumentException.class, ()->{
			manager.newCourse(0, "Programming Project", "Guillermo");
		});
	}

	@Test
	public void newCourseNameBlankTest (){
		assertThrows(InvalidInputArgumentException.class, ()->{
			manager.newCourse(1 , "", "Guillermo");
		});
	}

	@Test
	public void newCourseCoordinatorBlankTest (){
		assertThrows(InvalidInputArgumentException.class, ()->{
			manager.newCourse(10, "Programming Project", "");
		});
	}
}
