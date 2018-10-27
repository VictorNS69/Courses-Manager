package es.upm.pproject.tdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import es.upm.pproject.tdd.exceptions.*;

public class RestartedTest {

	private List <Student> students;
	private List <Course> courses;
	private Manager manager;
	
	@BeforeEach
	private void init() throws InvalidInputArgumentException {
		this.students = new ArrayList <Student>();
		this.courses = new ArrayList <Course>();
		this.manager = new Manager(students,courses);
		
	}
	
	@Test
	public void CourseNotEnteredTest () throws InvalidInputArgumentException, DuplicatedException {
		manager.newCourse(1, "PP", "Guillermo");
		assertThrows(InvalidInputArgumentException.class, ()->{
			manager.restarted(null);
		});
	}
	
	@Test
	public void CourseNotInListTest () throws InvalidInputArgumentException, DuplicatedException {
		Course c = new Course (1, "PP", "Guillermo");
		manager.newCourse(2, "PP", "Guillermo");
		assertThrows(NotInTheSystemException.class, ()->{
			manager.restarted(c);
		});
	}
	
	@Test
	public void CourseListEmptyTest () {
		Course c = new Course (1, "PP", "Guillermo");
		assertThrows(EmptyListException.class, ()->{
			manager.restarted(c);
			});
	}
	
	@Test
	public void CourseInListAndStudentsListIsEmptyTest () throws InvalidInputArgumentException, DuplicatedException,
					EmptyListException, NotInTheSystemException {
		Course c = new Course (1, "PP", "Guillermo");
		manager.newCourse(1, "PP", "Guillermo");
		manager.restarted(this.courses.get(0));
		assertEquals(c.getStudents().toString(), this.courses.get(0).getStudents().toString());
		assertEquals(0,c.getStudents().size());
		assertEquals(0,this.students.size());
	}
	@Test
	public void CourseInListAndStudentsListNotEmptyTest () throws NotInTheSystemException, AlreadyInTheSystemException, 
				MaxCapacityException, InvalidInputArgumentException, DuplicatedException, EmptyListException {
		Course c = new Course (1, "PP", "Guillermo");
		manager.newCourse(1, "PP", "Guillermo");
		manager.newStudent(1, "Alejandro Carmona", "alejandro@alumnos.upm.es");
		manager.newStudent(2, "Victor Nieves", "victor@alumnos.upm.es");
		manager.enrollStudent(1, 1);
		manager.enrollStudent(2, 1);
		manager.restarted(this.courses.get(0));
		this.courses = manager.listCourses();
		assertEquals(c.getStudents().toString(), this.courses.get(0).getStudents().toString());
		assertEquals(0,this.courses.get(0).getStudents().size());
		assertEquals(2,this.students.size());
	}
}
