package es.upm.pproject.tdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import es.upm.pproject.tdd.exceptions.*;


public class ListUsersTest {
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
	public void listUsersEmptyList1Test() {
		List <Student> s = manager.listUsers();
		assertEquals(this.students.toString(),s.toString());
		assertEquals(0,s.size());
	}
	
	@Test
	public void listUsersNoEmptyList2Test() throws DuplicatedException, InvalidInputArgumentException {
		manager.newStudent(1, "Alejandro Carmona Ayllon", "alejandro@alumnos.upm.es");
		List <Student> s = manager.listUsers();
		assertEquals(this.students.toString(),s.toString());
		assertEquals(1,s.size());
	}
	
	@Test
	public void listUsersNoEmptyList3Test() throws DuplicatedException, InvalidInputArgumentException {
		for (int i=1;i<21;i++) {
			manager.newStudent(i, "alejandro"+i, "alejandro"+1+"@alumnos.upm.es");
		}
		List <Student> s = manager.listUsers();
		assertEquals(this.students.toString(), s.toString());
		assertEquals(20,s.size());
	}
}
