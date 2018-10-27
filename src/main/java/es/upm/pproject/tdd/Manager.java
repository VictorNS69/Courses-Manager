package es.upm.pproject.tdd;

import java.util.*;
import es.upm.pproject.tdd.exceptions.*;

public class Manager implements MyInterface{
	private List <Student> students;
	private List <Course> courses;

	public Manager(List <Student> students, List <Course> courses ) throws InvalidInputArgumentException{
		if (students == null || courses == null)
			throw new InvalidInputArgumentException();
		
		this.students = students;
		this.courses = courses;
	}
	
	/** Insert a student in an list of students if it is not listed already.
	 * @param list
	 * @param student
	 * @throws DuplicatedException
	 */
	private void insertStudent(List <Student> list, Student student) throws DuplicatedException{
		if (list.isEmpty())
			list.add(student);
		
		else {
			for (Student s:list){
				if (s.getId() == student.getId())
					throw new DuplicatedException();
								
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

	/** Insert a course in a list of courses if it is not listed already.
	 * @param list
	 * @param course
	 * @throws DuplicatedException
	 */
	private void insertCourse(List <Course> list, Course course) throws DuplicatedException{
		if (list.isEmpty())
			list.add(course);
		
		else {
			for (Course c:list){
				if (c.getCode() == course.getCode())
					throw new DuplicatedException();

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

	@Override
	public void newCourse(int code, String name, String coordinator) throws InvalidInputArgumentException, 
						DuplicatedException{
		if (code == 0 || name.equals("") || coordinator.equals(""))
			throw new InvalidInputArgumentException();
		
		else {
			Course course = new Course(code, name, coordinator);
			insertCourse(courses, course);
		}
	}

	@Override
	public void newStudent(int id, String name, String email) throws DuplicatedException, 
						InvalidInputArgumentException {
		if (id == 0 || name.equals("") || email.equals(""))
			throw new InvalidInputArgumentException();
		
		else if (email.indexOf('@') == -1 || email.lastIndexOf('.') == email.length()-1) 
			throw new InvalidInputArgumentException();
		
		else {
			Student student = new Student(id, name, email);
			insertStudent(students, student);
		}
	}

	@Override
	public void enrollStudent(int id, int courseCod) throws NotInTheSystemException, AlreadyInTheSystemException, 
							MaxCapacityException, InvalidInputArgumentException, DuplicatedException {
		Course courseF = null; 
		Student studentF = null;
		if (this.courses.isEmpty()) 
			throw new NotInTheSystemException();
		
		for (Course c: this.courses) {
			if (this.courses.get(this.courses.size()-1).getCode() < courseCod) 
				throw new NotInTheSystemException();
			
			else if (c.getCode() == courseCod) 
				courseF = c;
			
		}
		for (Student s:this.students) {
			if (s.getId() == id ) {
				studentF = s;
				break;
			}
		}
		if (studentF == null) 
			throw new NotInTheSystemException();
		
		if (courseF == null)
			throw new NotInTheSystemException();
		
		if (courseF.getStudents().contains(studentF)) 
			throw new AlreadyInTheSystemException();
		
		if (courseF.getStudents().size() > 50) 
			throw new MaxCapacityException();
		
		insertStudent(courseF.getStudents(), studentF);
	}


	@Override
	public void cancel(Student student, Course course) throws InvalidInputArgumentException, EmptyListException, 
					NotInTheSystemException {
		if (this.students == null || this.courses == null || student == null || course == null) 
			throw new InvalidInputArgumentException();
		
		if (this.students.isEmpty() || this.courses.isEmpty()) 
			throw new EmptyListException();

		if (this.students.contains(student)) {
			if (this.courses.contains(course)) {
				if (this.courses.get(this.courses.indexOf(course)).getStudents().contains(student)) 
					this.courses.get(this.courses.indexOf(course)).getStudents().remove(student);
				
				else 
					throw new NotInTheSystemException();
			}
			else 
				throw new NotInTheSystemException();
		}
		else 
			throw new NotInTheSystemException();
	}

	@Override
	public void restarted(Course course) throws InvalidInputArgumentException, EmptyListException, NotInTheSystemException {
		if (course==null)
			throw new InvalidInputArgumentException();
		
		if(this.courses.isEmpty())
			throw new EmptyListException();
		
		if(this.courses.contains(course)){
			while(!this.courses.get(this.courses.indexOf(course)).getStudents().isEmpty())
				cancel(this.courses.get(this.courses.indexOf(course)).getStudents().get(0),
						this.courses.get(this.courses.indexOf(course)));
		}
		else
			throw new NotInTheSystemException();
	}

	@Override
	public List<Student> listStudentsInCourse(int code) throws InvalidInputArgumentException, EmptyListException, NotInTheSystemException {
		Course coursesR = null;
		List<Student> s;
		if (this.courses.isEmpty())
			throw new EmptyListException();
		
		if (code == 0)
			throw new NotInTheSystemException();
		
		for (Course c:this.courses) {
			if (c.getCode()==code){
				coursesR=c;
				break;
			}
			
		}
		if (coursesR==null)
			throw new NotInTheSystemException();
		
		s = coursesR.getStudents();
		return s;
	}

	@Override
	public List<Student> listUsers() {
		return this.students;
	}

	@Override
	public List<Course> listCourses() {
		return this.courses;
	}
}
