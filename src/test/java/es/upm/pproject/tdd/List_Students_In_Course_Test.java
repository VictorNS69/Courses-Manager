package es.upm.pproject.tdd;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


public class List_Students_In_Course_Test {

	private ArrayList <Student> students;
	private ArrayList <Course> courses;
	private Manager manager;
	
	
	@BeforeEach
	public void init() throws MyException {
		this.students = new ArrayList <Student>();
		this.courses = new ArrayList <Course>();
		this.manager = new Manager(students,courses);
	}
	@Test
	public void code_is_zero_test() throws MyException {
		manager.new_course(1, "Programming Project", "Guillermo");
		
		assertThrows(Exception.class, ()->{
		ArrayList <Student> s = manager.list_students_in_course(0);
		});
		
	}
	@Test
	public void code_is_not_in_courses_test() throws MyException {
		manager.new_course(1, "Programming Project", "Guillermo");
		
		assertThrows(Exception.class, ()->{
		ArrayList <Student> s = manager.list_students_in_course(2);
		});
	}
	@Test
	public void code_is_in_course_test() throws MyException {
		manager.new_course(1, "Programming Project", "Guillermo");
		manager.new_student(1, "Alejandro Carmona", "alejandro@alumnos.upm.es");
		manager.enroll_student(1, 1);
		ArrayList <Student> ls = new ArrayList <Student> ();
		Student s1 = new Student (1, "Alejandro Carmona", "alejandro@alumnos.upm.es");
		ls.add(s1);
		ArrayList <Student> s = manager.list_students_in_course(1);
		assertEquals(ls.toString(), s.toString());
		assertEquals(1,s.size());
	}
	@Test
	public void code_is_in_course_list_empty_test() throws MyException {
		manager.new_course(1, "programing Project", "Guilleromo");
		ArrayList <Student> s = manager.list_students_in_course(1);
		assertEquals(this.students.toString(), s.toString());
		assertEquals(0, s.size());
	}
	@Test
	public void code_is_in_courses_lists_not_empty_test() throws MyException{
		manager.new_course(1, "Programming Project", "Guillermo");
		manager.new_course(2, "ssoo", "Frosal");
		manager.new_course(3, "Pdl", "Juan");
		
		manager.new_student(1, "Alejandro Carmona", "alejandro@alumnos.upm.es");
		manager.new_student(2, "Victor Nieves", "victor@alumnos.upm.es");
		manager.new_student(3, "Danilo Morgera", "danilo@alumnos.upm.es");
		
		manager.enroll_student(1, 1);
		manager.enroll_student(2, 1);
		
		manager.enroll_student(1, 2);
		manager.enroll_student(2, 2);
		manager.enroll_student(3, 2);
		
		manager.enroll_student(3, 3);

		ArrayList <Student> ls1 = new ArrayList <Student> (), ls2 = new ArrayList <Student> (), ls3 = new ArrayList <Student> ();
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
		
		ArrayList <Student> st = manager.list_students_in_course(1);
		assertEquals(ls1.toString(), st.toString());
		assertEquals(2, st.size());
		
		ArrayList <Student> st1 = manager.list_students_in_course(2);
		assertEquals(ls2.toString(), st1.toString());
		assertEquals(3, st1.size());
		
		ArrayList <Student> st2 = manager.list_students_in_course(3);
		assertEquals(ls3.toString(), st2.toString());
		assertEquals(1, st2.size());
	}
}
