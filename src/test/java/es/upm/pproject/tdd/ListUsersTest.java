package es.upm.pproject.tdd;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


public class ListUsersTest {
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
	public void list_users_empty_list1_test() {
		
		List <Student> s = manager.listUsers();
		assertEquals(this.students.toString(),s.toString());
		assertEquals(0,s.size());
	}
	
	@Test
	public void list_users_no_empty_list2_test() throws MyException {
		manager.newStudent(1, "Alejandro Carmona Ayllon", "alejandro@alumnos.upm.es");
		List <Student> s = manager.listUsers();
		assertEquals(this.students.toString(),s.toString());
		assertEquals(1,s.size());
	}
	
	@Test
	public void list_users_no_empty_list3_test() throws MyException {
		for (int i=1;i<21;i++) {
			manager.newStudent(i, "alejandro"+i, "alejandro"+1+"@alumnos.upm.es");
		}
		List <Student> s = manager.listUsers();
		assertEquals(this.students.toString(), s.toString());
		assertEquals(20,s.size());
	}
}
