package es.upm.pproject.tdd;

import es.upm.pproject.tdd.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.zip.DataFormatException;
import java.util.*;

public class MyTest{
  private ArrayList <Student> students = new ArrayList <Student>();
  private ArrayList <Course> courses = new ArrayList <Course>();
  private Manager manager = new Manager(students, courses);
  @Test
  public void new_course_ok_empty_list_test(){
    try {
      manager.new_course(1, "Programming Project", "Guillermo");
      assertEquals(1, this.courses.size());
    }
    catch (DataFormatException e){
      e = new DataFormatException("Error creating course.");
    }
  }

  @Test
  @Disabled
  public void new_course_ok_not_empty_list_test(){
    try {
      manager.new_course(2, "Math", "Luisa");
      manager.new_course(3, "Spanish", "Alex");
      assertEquals(2, this.courses.size());
    }
    catch (DataFormatException e){
      e = new DataFormatException("Error creating course.");
    }
  }

  @Test
  public void new_course_code_blank_test (){
    assertThrows(DataFormatException.class, ()->{
      manager.new_course(0, "Programming Project", "Guillermo");
    });
  }

  @Test
  public void new_course_name_blank_test (){
    assertThrows(DataFormatException.class, ()->{
      manager.new_course(1 , "", "Guillermo");
    });
  }

  @Test
  public void new_course_coordinator_blank_test (){
    assertThrows(DataFormatException.class, ()->{
      manager.new_course(10, "Programming Project", "");
    });
  }

  /*ArrayList <Course> courses = new ArrayList <Course>();
  new_course(1, "Programming Project", "Guillermo");
  @Test
  void list_courses_test(){
    int = 2;
  }*/
}
