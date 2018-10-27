package es.upm.pproject.tdd;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class Restarted_Test {

	private List <Student> students;
	private List <Course> courses;
	private Manager manager;
	
	@BeforeEach
	private void init() throws MyException {
		this.students = new ArrayList <Student>();
		this.courses = new ArrayList <Course>();
		this.manager = new Manager(students,courses);
		
	}
	@Test
	public void CourseNotEnteredTest () throws MyException {
		manager.new_course(1, "PP", "Guillermo");
		assertThrows(Exception.class, ()->{
			manager.restarted(null);
			});
	}
	@Test
	public void CourseNotInListTest () throws MyException {
		Course c = new Course (1, "PP", "Guillermo");
		manager.new_course(2, "PP", "Guillermo");
		assertThrows(Exception.class, ()->{
			manager.restarted(c);
			});
	}
	@Test
	public void CourseListEmptyTest () throws MyException {
		Course c = new Course (1, "PP", "Guillermo");
		assertThrows(Exception.class, ()->{
			manager.restarted(c);
			});
	}
	@Test
	public void CourseInListAndEstudentsListIsEmptyTest () throws MyException {
		Course c = new Course (1, "PP", "Guillermo");
		manager.new_course(1, "PP", "Guillermo");
		manager.restarted(this.courses.get(0));
		assertEquals(c.getStudents().toString(), this.courses.get(0).getStudents().toString());
		assertEquals(0,c.getStudents().size());
		assertEquals(0,this.students.size());
	}
	@Test
	public void CourseInListAndEstudentsListNotEmptyTest () throws MyException {
		Course c = new Course (1, "PP", "Guillermo");
		manager.new_course(1, "PP", "Guillermo");
		manager.new_student(1, "Alejandro Carmona", "alejandro@alumnos.upm.es");
		manager.new_student(2, "Victor Nieves", "victor@alumnos.upm.es");
		manager.enroll_student(1, 1);
		manager.enroll_student(2, 1);
		manager.restarted(this.courses.get(0));
		this.courses = manager.list_courses();
		assertEquals(c.getStudents().toString(), this.courses.get(0).getStudents().toString());
		assertEquals(0,this.courses.get(0).getStudents().size());
		assertEquals(2,this.students.size());

		
	}
}
