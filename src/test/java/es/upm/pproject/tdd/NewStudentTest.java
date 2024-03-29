package es.upm.pproject.tdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import es.upm.pproject.tdd.exceptions.*;

public class NewStudentTest{
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
  public void newStudentOkEmptyListTest() throws DuplicatedException, InvalidInputArgumentException{
      manager.newStudent(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      assertEquals(1, this.students.size());
      Student s = new Student(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      assertEquals (s.toString(), this.students.get(0).toString());
  }
  
  @Test
  public void newStudentOkNotEmptyList1Test() throws DuplicatedException, InvalidInputArgumentException{
      manager.newStudent(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      manager.newStudent(200300, "alejandro carmona", "alejandro.carmona.ayllon@alumnos.upm.es");
      assertEquals(2, this.students.size());
      Student s1 = new Student(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      Student s2 = new Student(200300, "alejandro carmona", "alejandro.carmona.ayllon@alumnos.upm.es");
      assertEquals (s2.toString(), this.students.get(0).toString());
      assertEquals (s1.toString(), this.students.get(1).toString());
  }
  
  @Test
  public void newStudentOkNotEmptyList2Test() throws DuplicatedException, InvalidInputArgumentException{
      manager.newStudent(150375, "victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      manager.newStudent(100200, "Xavier Martinez", "ejemplo@alumnos.upm.es");
      assertEquals(2, this.students.size());
      Student s1 = new Student(150375, "victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      Student s2 = new Student(100200, "Xavier Martinez", "ejemplo@alumnos.upm.es");
      assertEquals (s1.toString(), this.students.get(0).toString());
      assertEquals (s2.toString(), this.students.get(1).toString());
  }
  
  @Test
  public void newStudentOkNotEmptyList3Test() throws DuplicatedException, InvalidInputArgumentException{
      manager.newStudent(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      manager.newStudent(100100, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      assertEquals(2, this.students.size());
      Student s1 = new Student(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      Student s2 = new Student(100100, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      assertEquals (s2.toString(), this.students.get(0).toString());
      assertEquals (s1.toString(), this.students.get(1).toString());
  }
  
  @Test
  public void newStudentOkNotEmptyList4Test() throws DuplicatedException, InvalidInputArgumentException{
      manager.newStudent(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      manager.newStudent(155555, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      assertEquals(2, this.students.size());
      Student s1 = new Student(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      Student s2 = new Student(155555, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      assertEquals (s2.toString(), this.students.get(1).toString());
      assertEquals (s1.toString(), this.students.get(0).toString());
  }
  
  @Test
  public void newStudentDuplicated1Test(){
	  assertThrows(DuplicatedException.class, ()->{
		  manager.newStudent(1, "a", "test@tst.com");
		  manager.newStudent(2, "b", "test@tst.com");
		  manager.newStudent(3, "c", "test@tst.com");
		  manager.newStudent(2, "b", "test@tst.com");
	  });
	  
  }
  
  @Test
  public void newStudentDuplicated2Test() {
	  assertThrows(DuplicatedException.class, ()->{
    	  manager.newStudent(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
          manager.newStudent(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
        });
  }
  
  @Test
  public void newStudentBlankIdTest() {
	  assertThrows(InvalidInputArgumentException.class, ()->{
    	  manager.newStudent(0, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
        });
  }
  
  @Test
  public void newStudentBlankNameTest() {
	  assertThrows(InvalidInputArgumentException.class, ()->{
    	  manager.newStudent(100, "", "victor.nieves.sanchez@alumnos.upm.es");
        });
  }
  
  @Test
  public void newStudentBlankEmailTest() {
	  assertThrows(InvalidInputArgumentException.class, ()->{
    	  manager.newStudent(10, "Victor Nieves", "");
        });
  }
  
  @Test
  public void newStudentWrongEmail1Test() {
	  assertThrows(InvalidInputArgumentException.class, ()->{
    	  manager.newStudent(10, "Victor Nieves", "victor.nieves.sanchez.alumnos.upm.es");
        });
  }
  
  @Test
  public void newStudentWrongEmail2Test() {
	  assertThrows(InvalidInputArgumentException.class, ()->{
    	  manager.newStudent(111, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es.");
        });
  }
  
  @Test
  public void newStudentWrongEmail3Test() {
	  assertThrows(InvalidInputArgumentException.class, ()->{
    	  manager.newStudent(111, "Victor Nieves", "victornieves");
        });
  }
}
