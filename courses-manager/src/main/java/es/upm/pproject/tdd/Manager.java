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
								
				else if (student.getName().toLowerCase().compareTo(s.getName().toLowerCase()) == 0){
					if (student.getId() < s.getId()){
						list.add(list.indexOf(s), student);
						break;
					}		
					else {
						list.add(list.indexOf(s)+1, student);
						break;
					}		
				}
				else if(student.getName().toLowerCase().compareTo(s.getName().toLowerCase()) < 0){
					list.add(list.indexOf(s), student);
					break;
				}
				else if(list.get(list.size()-1).getName().toLowerCase().compareTo(student.getName().toLowerCase()) < 0) {
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
		for (Course c: this.courses) {
			if (c.getCode() == course_cod) {}
		}
		/*for (Course c: this.courses) {
			if (c.getCode() == course_cod) {
				for (Student s: c.getStudents()) {
					if (s.getId() == id) {
						throw new MyException ("Error: Student already in this course.");
					}
					else if 
					else {
						if (s == students.get(students.size()-1) && s.getId() != id) {
							//si es ultimo de lista y no coincide
							throw new MyException("Error: Student not in the system.");
						}
					}	
				}
			}
			else if (c == courses.get(courses.size()-1) && c.getCode() != course_cod) {
					//si es ultimo y no coincide
					throw new MyException ("Error: this course is not in the system.");
			}
		}*/
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
