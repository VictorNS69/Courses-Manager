package es.upm.pproject.tdd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class New_Course_Test{
  private ArrayList <Student> students = new ArrayList <Student>();
  private ArrayList <Course> courses = new ArrayList <Course>();
  private Manager manager = new Manager(students, courses);
  
  @Test
  public void new_course_ok_empty_list_test() throws MyException{
      manager.new_course(1, "Programming Project", "Guillermo");
      assertEquals(1, this.courses.size());
      Course c = new Course(1, "Programming Project", "Guillermo");
      assertEquals (c.toString(), this.courses.get(0).toString());
      /*
      assertEquals(1, courses.get(0).getCode());
      assertEquals("Programming Project", courses.get(0).getName());
      assertEquals("Guillermo", courses.get(0).getCoordinator());
      */
  }

  @Test
  public void new_course_ok_not_empty_list_1_test() throws MyException{
      manager.new_course(1, "Programming Project", "Guillermo");
      manager.new_course(2, "Math", "Luisa");
      assertEquals(2, this.courses.size());
      Course c1 = new Course(1, "Programming Project", "Guillermo");
      Course c2 = new Course(2, "Math", "Luisa");
      assertEquals (c1.toString(), this.courses.get(0).toString());
      assertEquals (c2.toString(), this.courses.get(1).toString());
      /*
      assertEquals(1, courses.get(0).getCode());
      assertEquals("Programming Project", courses.get(0).getName());
      assertEquals("Guillermo", courses.get(0).getCoordinator());
      assertEquals(2, courses.get(1).getCode());
      assertEquals("Math", courses.get(1).getName());
      assertEquals("Luisa", courses.get(1).getCoordinator());
      */
   }

  @Test
  public void new_course_ok_not_empty_list_2_test() throws MyException{
      manager.new_course(2, "Programming Project", "Guillermo");
      manager.new_course(1, "Math", "Luisa");
      assertEquals(2, this.courses.size());
      Course c2 = new Course(1, "Math", "Luisa");
      Course c1 = new Course(2, "Programming Project", "Guillermo");
      assertEquals (c2.toString(), this.courses.get(0).toString());
      assertEquals (c1.toString(), this.courses.get(1).toString());
  }
  
  @Test
  public void new_course_duplicated_test() {
	  assertThrows(Exception.class, ()->{
    	  manager.new_course(1, "Programming Project", "Guillermo");
          manager.new_course(1, "Math", "Luisa");
        });
  }
  
  @Test
  public void new_course_code_blank_test (){
    assertThrows(MyException.class, ()->{
      manager.new_course(0, "Programming Project", "Guillermo");
    });
  }

  @Test
  public void new_course_name_blank_test (){
    assertThrows(MyException.class, ()->{
      manager.new_course(1 , "", "Guillermo");
    });
  }

  @Test
  public void new_course_coordinator_blank_test (){
    assertThrows(MyException.class, ()->{
      manager.new_course(10, "Programming Project", "");
    });
  }
}
