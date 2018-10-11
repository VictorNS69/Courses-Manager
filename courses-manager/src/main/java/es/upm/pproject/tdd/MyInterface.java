package es.upm.pproject.tdd;
import java.io.*;

public interface MyInterface{
  public void new_course(int code, String name, String coordinator) throws Exception;
  public void new_student(int id, String name, String email) throws Exception;
  public void enroll_student(int id, int course_cod);
  public void cancel (Student student, Course course) throws Exception;
  public void restarted (Course course) throws Exception;
  public Student[] list_students_in_course(int code);
  public Student[] list_users();
  public Course[] list_courses(Course course);
}
