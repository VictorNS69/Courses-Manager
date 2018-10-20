package es.upm.pproject.tdd;

import java.util.*;

public class Manager implements MyInterface{
	private ArrayList <Student> students;
	private ArrayList <Course> courses;

	public Manager(ArrayList <Student> students, ArrayList <Course> courses ) throws MyException{
		if (students == null || courses == null)
			throw new MyException ("Error: cannot be null lists.");
		this.students = students;
		this.courses = courses;
	}
	
	/** Insert a student in an list of students if it is not listed already.
	 * @param list
	 * @param student
	 * @throws MyException
	 */
	private void insert_Student(ArrayList <Student> list, Student student) throws MyException{
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

	/** Insert a course in a list of courses if it is not listed already.
	 * @param list
	 * @param course
	 * @throws MyException
	 */
	private void insert_Course(ArrayList <Course> list, Course course) throws MyException{
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

	@Override
	public void new_course(int code, String name, String coordinator) throws MyException{
		if (code == 0 || name.equals("") || coordinator.equals(""))
			throw new MyException("Error: Cannot be blank field.");
		else {
			Course course = new Course(code, name, coordinator);
			insert_Course(courses, course);
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
			insert_Student(students, student);
		}

	}

	@Override
	public void enroll_student(int id, int course_cod) throws MyException {
		Course course_f = null; 
		Student student_f = null;
		if (this.courses.isEmpty()) {
			throw new MyException ("Error: Course not in the system.");
		}
		for (Course c: this.courses) {
			if (this.courses.get(this.courses.size()-1).getCode() < course_cod) {
				throw new MyException ("Error: Course not in the system.");
			}
			else if (c.getCode() == course_cod) {
				course_f = c;
			}
		}
		for (Student s:this.students) {
			if (s.getId() == id ) {
				student_f = s;
				break;
			}
		}
		if (student_f == null) {
			throw new MyException ("Error: Student not in the system.");
		}
		if (course_f.getStudents().contains(student_f)) {
			throw new MyException ("Error: Student already in this course.");
		}
		if (course_f.getStudents().size() > 50) {
			throw new MyException ("Error: Max capacity in this course (50).");
		}
		insert_Student(course_f.getStudents(), student_f);
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
		return this.students;
	}

	@Override
	public ArrayList<Course> list_courses() {
		return this.courses;
	}
}
