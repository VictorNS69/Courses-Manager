package es.upm.pproject.tdd;

import es.upm.pproject.tdd.*;
import java.io.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.zip.DataFormatException;


public class MyTest{
  @Test
  void new_course_ok_test(){
    try {
      Course course = new Course(1, "Programming Project", "Guillermo");
      assertEquals(course.getCode(), 1);
      assertEquals(course.getName(), "Programming Project");
      assertEquals(course.getCoordinator(), "Guillermo");
    }
    catch (DataFormatException e){
      e = new DataFormatException("Error creating course.");
    }
  }
  @Test
  void new_course_code_blank_test (){
    assertThrows(DataFormatException.class, ()->{
      Course course = new Course(0, "Programming Project", "Guillermo");
    });
  }
}
