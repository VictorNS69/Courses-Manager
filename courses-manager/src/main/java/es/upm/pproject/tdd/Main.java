package es.upm.pproject.tdd;

import es.upm.pproject.tdd.*;
import java.util.*;
import java.util.zip.DataFormatException;
import es.upm.pproject.tdd.Course;
import es.upm.pproject.tdd.MyInterface;
import es.upm.pproject.tdd.Student;
import es.upm.pproject.tdd.Manager;
public class Main{
  public static void main(String [ ] args) throws MyException{
    ArrayList <Student> students = new ArrayList <Student>();
    ArrayList <Course> courses = new ArrayList <Course>();
    Manager manager = new Manager(students, courses);
    manager.new_course(1, "Programming Project", "Guillermo");
    //manager.new_course(1, "Programming Project", "Guillermo");
    manager.new_course(2, "PP", "Guille");
    System.out.println(courses.size());
    Course c1 = new Course (1, "Programming Project", "Guillermo");
    Course c2 = new Course (2, "MM", "Guillerm");
    ArrayList <Course> list = new ArrayList<Course> ();
    list.add(c1);
    list.add(c2);
    //System.out.println(list.size());
    Course c3 = new Course (3, "lul", "uillerm");
    list.add(list.indexOf(c2),c3);
    
	for (Course c: courses){
		System.out.println(c.getCode());
		System.out.println(c.toString());
	}
  }
}
