package es.upm.pproject.tdd;

import es.upm.pproject.tdd.*;
import java.util.*;
import java.util.zip.DataFormatException;

	public class Manager implements MyInterface{
	  ArrayList <Student> students = new ArrayList <Student>();
	  ArrayList <Course> courses = new ArrayList <Course>();

		public void new_course(int code, String name, String coordinator) throws DataFormatException{
			try{
		  		Course course = new Course(code, name, coordinator);
					if (courses.contains(course)){
						throw new Exception("Cannot create a course twice.");
					}
					else {
						courses.add(course);
					}
			}
			catch (Exception e){
					e = new Exception("Culdnt create the course.");
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
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Course> list_courses() {
			// TODO Auto-generated method stub
				return null;
			}
		}
