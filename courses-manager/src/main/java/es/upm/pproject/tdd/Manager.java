package es.upm.pproject.tdd;

import es.upm.pproject.tdd.*;
import java.util.*;
import java.util.zip.DataFormatException;

public class Manager implements MyInterface{
  private ArrayList <Student> students;
  private ArrayList <Course> courses;

  public Manager(ArrayList <Student> students, ArrayList <Course> courses ){
    this.students = students;
    this.courses = courses;
  }

  private void insertStudent(ArrayList <Student> list, Student student) throws Exception{
    if (list.isEmpty())
    	list.add(student);
    else {
    	for (Student s:list){
    		if (s.getName() == student.getName())
    			throw new Exception("Duplicated student.");
    		else if(student.getName().compareTo(s.getName()) < 0){
    			list.add(list.indexOf(s), student);
    			break;
    		}
    	}
    }
  }

	private void insertCourse(ArrayList <Course> list, Course course) throws Exception{
		if (list.isEmpty())
			list.add(course);
		else {
			for (Course c:list){
				if (c.getCode() == course.getCode())
					throw new Exception("Duplicated course.");
				else if(course.getCode() < c.getCode()){
					list.add(list.indexOf(c), course);
					break;
				}
			}
		}
	 }

	public void new_course(int code, String name, String coordinator) throws DataFormatException{
    if (code == 0 || name.equals("") || coordinator.equals(""))
      throw new DataFormatException("Cannot be blank field.");
  	else {
      try {
        Course course = new Course(code, name, coordinator);
  	     insertCourse(courses, course);
       }
       catch (Exception e){
         e = new Exception("Error creating the course.");
       }
    }
	}

	@Override
	public void new_student(int id, String name, String email) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void enroll_student(int id, int course_cod) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancel(Student student, Course course) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void restarted(Course course) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Student> list_students_in_course(int code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> list_users() {
		return null;//this.courses;
	}

	@Override
	public ArrayList<Course> list_courses() {
		// TODO Auto-generated method stub
			return null;
	}
}