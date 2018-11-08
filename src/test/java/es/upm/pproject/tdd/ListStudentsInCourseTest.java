package es.upm.pproject.tdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import es.upm.pproject.tdd.exceptions.*;


public class ListStudentsInCourseTest {

	private List <Student> students;
	private List <Course> courses;
	private Manager manager;
	
	
	@BeforeEach
	public void Init() throws InvalidInputArgumentException {
		this.students = new ArrayList <Student>();
		this.courses = new ArrayList <Course>();
		this.manager = new Manager(students,courses);
	}
	
	@Test
	public void CodeIsZeroTest() throws InvalidInputArgumentException, 
					DuplicatedException{ 
		manager.newCourse(1, "Programming Project", "Guillermo");
		assertThrows(NotInTheSystemException.class, ()->{
			List <Student> s = manager.listStudentsInCourse(0);
		});
	}

	@Test
	public void CourseEmptyTest() throws InvalidInputArgumentException, 
				DuplicatedException{ 
		assertThrows(EmptyListException.class, () ->{
			List <Student> s = manager.listStudentsInCourse(0);
		});
	}
	
	@Test
	public void CodeIsNotInCoursesTest() throws InvalidInputArgumentException, 
					DuplicatedException{ 
		manager.newCourse(1, "Programming Project", "Guillermo");
		assertThrows(NotInTheSystemException.class, ()->{
			List <Student> s = manager.listStudentsInCourse(2);
		});
	}
	
	@Test
	public void CodeIsInCourseTest() throws NotInTheSystemException, AlreadyInTheSystemException, 
					MaxCapacityException, InvalidInputArgumentException, DuplicatedException, EmptyListException{
		manager.newCourse(1, "Programming Project", "Guillermo");
		manager.newStudent(1, "Alejandro Carmona", "alejandro@alumnos.upm.es");
		manager.enrollStudent(1, 1);
		List <Student> ls = new ArrayList <Student> ();
		Student s1 = new Student (1, "Alejandro Carmona", "alejandro@alumnos.upm.es");
		ls.add(s1);
		List <Student> s = manager.listStudentsInCourse(1);
		assertEquals(ls.toString(), s.toString());
		assertEquals(1,s.size());
	}
	
	@Test
	public void CodeIsInCourseListEmptyTest() throws InvalidInputArgumentException, DuplicatedException, 
					EmptyListException, NotInTheSystemException {
		manager.newCourse(1, "programing Project", "Guilleromo");
		List <Student> s = manager.listStudentsInCourse(1);
		assertEquals(this.students.toString(), s.toString());
		assertEquals(0, s.size());
	}
	
	@Test
	public void CodeIsInCoursesListsNotEmptyTest() throws InvalidInputArgumentException, DuplicatedException,
					NotInTheSystemException, AlreadyInTheSystemException, MaxCapacityException, EmptyListException{
		manager.newCourse(1, "Programming Project", "Guillermo");
		manager.newCourse(2, "ssoo", "Frosal");
		manager.newCourse(3, "Pdl", "Juan");
		
		manager.newStudent(1, "Alejandro Carmona", "alejandro@alumnos.upm.es");
		manager.newStudent(2, "Victor Nieves", "victor@alumnos.upm.es");
		manager.newStudent(3, "Danilo Morgera", "danilo@alumnos.upm.es");
		
		manager.enrollStudent(1, 1);
		manager.enrollStudent(2, 1);
		
		manager.enrollStudent(1, 2);
		manager.enrollStudent(2, 2);
		manager.enrollStudent(3, 2);
		
		manager.enrollStudent(3, 3);

		List <Student> ls1 = new ArrayList <Student> (), ls2 = new ArrayList <Student> (), ls3 = new ArrayList <Student> ();
		Student s1 = new Student (1, "Alejandro Carmona", "alejandro@alumnos.upm.es");
		Student s2 = new Student (2, "Victor Nieves", "victor@alumnos.upm.es");
		Student s3 = new Student (3, "Danilo Morgera", "danilo@alumnos.upm.es");
		
		//students list course 1
		ls1.add(s1);
		ls1.add(s2);
		//students list course 2, ordeno la lista a mano
		ls2.add(s1);
		ls2.add(s3);
		ls2.add(s2);
		//students list course 3
		ls3.add(s3);
		
		List <Student> st = manager.listStudentsInCourse(1);
		assertEquals(ls1.toString(), st.toString());
		assertEquals(2, st.size());
		
		List <Student> st1 = manager.listStudentsInCourse(2);
		assertEquals(ls2.toString(), st1.toString());
		assertEquals(3, st1.size());
		
		List <Student> st2 = manager.listStudentsInCourse(3);
		assertEquals(ls3.toString(), st2.toString());
		assertEquals(1, st2.size());
	}
}
