package es.upm.pproject.tdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class New_Student_Test{
  private ArrayList <Student> students = new ArrayList <Student>();
  private ArrayList <Course> courses = new ArrayList <Course>();
  private Manager manager = new Manager(students, courses);
  
  @Test
  public void new_student_ok_empty_list_test() throws MyException{
      manager.new_student(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      assertEquals(1, this.students.size());
      Student s = new Student(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      assertEquals (s.toString(), this.students.get(0).toString());
  }
  
  @Test
  public void new_student_ok_not_empty_list_1_test() throws MyException{
      manager.new_student(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      manager.new_student(200300, "Alejandro Carmona", "alejandro.carmona.ayllon@alumnos.upm.es");
      assertEquals(2, this.students.size());
      Student s1 = new Student(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      Student s2 = new Student(200300, "Alejandro Carmona", "alejandro.carmona.ayllon@alumnos.upm.es");
      assertEquals (s2.toString(), this.students.get(0).toString());
      assertEquals (s1.toString(), this.students.get(1).toString());
  }
  
  @Test
  public void new_student_ok_not_empty_list_2_test() throws MyException{
      manager.new_student(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      manager.new_student(100200, "Xavier Martinez", "ejemplo@alumnos.upm.es");
      assertEquals(2, this.students.size());
      Student s1 = new Student(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
      Student s2 = new Student(100200, "Xavier Martinez", "ejemplo@alumnos.upm.es");
      assertEquals (s1.toString(), this.students.get(0).toString());
      assertEquals (s2.toString(), this.students.get(1).toString());
  }
  
  @Test
  public void new_student_duplicated_test() {
	  assertThrows(Exception.class, ()->{
    	  manager.new_student(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
          manager.new_student(150375, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
        });
  }
  
  @Test
  public void new_student_blank_id_test() {
	  assertThrows(Exception.class, ()->{
    	  manager.new_student(0, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es");
        });
  }
  
  @Test
  public void new_student_blank_name_test() {
	  assertThrows(Exception.class, ()->{
    	  manager.new_student(100, "", "victor.nieves.sanchez@alumnos.upm.es");
        });
  }
  
  @Test
  public void new_student_blank_email_test() {
	  assertThrows(Exception.class, ()->{
    	  manager.new_student(10, "Victor Nieves", "");
        });
  }
  
  @Test
  public void new_student_wrong_email_1_test() {
	  assertThrows(Exception.class, ()->{
    	  manager.new_student(10, "Victor Nieves", "victor.nieves.sanchez.alumnos.upm.es");
        });
  }
  
  @Test
  public void new_student_wrong_email_2_test() {
	  assertThrows(Exception.class, ()->{
    	  manager.new_student(111, "Victor Nieves", "victor.nieves.sanchez@alumnos.upm.es.");
        });
  }
  
  @Test
  public void new_student_wrong_email_3_test() {
	  assertThrows(Exception.class, ()->{
    	  manager.new_student(111, "Victor Nieves", "victornieves");
        });
  }
}