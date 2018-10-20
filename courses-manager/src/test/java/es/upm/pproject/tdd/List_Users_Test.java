package es.upm.pproject.tdd;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


public class List_Users_Test {
	private ArrayList <Student> students;
	private ArrayList <Course> courses;
	private Manager manager;
	
	@BeforeEach
	private void init() throws MyException {
		this.students = new ArrayList <Student>();
		this.courses = new ArrayList <Course>();
		this.manager = new Manager(students,courses);
		
	}
	
	
	@Test
	public void list_users_empty_list1_test() {
		
		ArrayList <Student> s = manager.list_users();
		assertEquals(this.students.toString(),s.toString());
		assertEquals(0,s.size());
	}
	@Test
	public void list_users_no_empty_list2_test() throws MyException {
		manager.new_student(1, "Alejandro Carmona Ayllon", "alejandro@alumnos.upm.es");
		ArrayList <Student> s = manager.list_users();
		assertEquals(this.students.toString(),s.toString());
		assertEquals(1,s.size());
	}
	@Test
	public void list_users_no_empty_list3_test() throws MyException {
		for (int i=1;i<21;i++) {
			manager.new_student(i, "alejandro"+i, "alejandro"+1+"@alumnos.upm.es");
		}
		ArrayList <Student> s = manager.list_users();
		assertEquals(this.students.toString(), s.toString());
		assertEquals(20,s.size());
	}
	@Test
	public void list_users_null_C_list_test() throws MyException {
		
		assertThrows(Exception.class, ()->{
			this.manager = new Manager(this.students,null);
			manager.new_student(1, "victor nieves", "victor.nieves@alumnos.upm.es");
			ArrayList <Student> s = manager.list_users();
		});
		}
	@Test
public void list_users_null_S_list_test() throws MyException {
		
		assertThrows(Exception.class, ()->{
			this.manager = new Manager(null,this.courses);
			manager.new_student(1, "victor nieves", "victor.nieves@alumnos.upm.es");
			ArrayList <Student> s = manager.list_users();
		});
		}
	
}
