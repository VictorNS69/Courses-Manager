package es.upm.pproject.tdd;

import java.util.*;

public class Manager implements MyInterface{
	private ArrayList <Student> students;
	private ArrayList <Course> courses;

	public Manager(ArrayList <Student> students, ArrayList <Course> courses ){
		this.students = students;
		this.courses = courses;
	}

	private void insertStudent(ArrayList <Student> list, Student student) throws MyException{
		if (list.isEmpty())
			list.add(student);
		else {
			for (Student s:list){
				if (s.getId() == student.getId())
					throw new MyException("Error: Duplicated (code) student.");
				
				else if(student.getName().compareTo(s.getName()) < 0){
					list.add(list.indexOf(s), student);
					break;
				}
				else if(list.get(list.size()-1).getName().compareTo(student.getName()) < 0) {
					list.add(student);
					break;
				}
			}
		}
	}

	private void insertCourse(ArrayList <Course> list, Course course) throws MyException{
		if (list.isEmpty())
			list.add(course);
		else {
			for (Course c:list){
				if (c.getCode() == course.getCode())
					throw new MyException("Error: Duplicated course.");

				else if(course.getCode() < c.getCode()){
					list.add(list.indexOf(c), course);
					break;
				}

				else if (list.get(list.size()-1).getCode() < course.getCode()) {
					list.add(course);
					break;
				}
			}
		}
	}

	public void new_course(int code, String name, String coordinator) throws MyException{
		if (code == 0 || name.equals("") || coordinator.equals(""))
			throw new MyException("Error: Cannot be blank field.");
		else {
			Course course = new Course(code, name, coordinator);
			insertCourse(courses, course);
		}
	}

	@Override
	public void new_student(int id, String name, String email) throws MyException {
		if (id == 0 || name.equals("") || email.equals(""))
			throw new MyException("Error: Cannot be blank field.");
		
		else if (email.indexOf('@') == -1 || email.lastIndexOf('.') == email.length()-1) {
			throw new MyException("Error: Invalid email.");
		}
		
		else {
			Student student = new Student(id, name, email);
			insertStudent(students, student);
		}

	}

	@Override
	public void enroll_student(int id, int course_cod) throws MyException {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancel(Student student, Course course) throws MyException {
		// TODO Auto-generated method stub

	}

	@Override
	public void restarted(Course course) throws MyException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Student> list_students_in_course(int code) throws MyException {
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
