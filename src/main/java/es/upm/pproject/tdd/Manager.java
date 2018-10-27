package es.upm.pproject.tdd;

import java.util.*;

public class Manager implements MyInterface{
	private List <Student> students;
	private List <Course> courses;

	public Manager(List <Student> students, List <Course> courses ) throws MyException{
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
	private void insertStudent(List <Student> list, Student student) throws MyException{
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
	private void insertCourse(List <Course> list, Course course) throws MyException{
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
	public void newCourse(int code, String name, String coordinator) throws MyException{
		if (code == 0 || name.equals("") || coordinator.equals(""))
			throw new MyException("Error: Cannot be blank field.");
		else {
			Course course = new Course(code, name, coordinator);
			insertCourse(courses, course);
		}
	}

	@Override
	public void newStudent(int id, String name, String email) throws MyException {
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
	public void enrollStudent(int id, int courseCod) throws MyException {
		Course courseF = null; 
		Student studentF = null;
		if (this.courses.isEmpty()) {
			throw new MyException ("Error: Course not in the system.");
		}
		for (Course c: this.courses) {
			if (this.courses.get(this.courses.size()-1).getCode() < courseCod) {
				throw new MyException ("Error: Course not in the system.");
			}
			else if (c.getCode() == courseCod) {
				courseF = c;
			}
		}
		for (Student s:this.students) {
			if (s.getId() == id ) {
				studentF = s;
				break;
			}
		}
		if (studentF == null) {
			throw new MyException ("Error: Student not in the system.");
		}
		if (courseF == null)
			throw new MyException ("Error: Student not in the system.");
		if (courseF.getStudents().contains(studentF)) {
			throw new MyException ("Error: Student already in this course.");
		}
		if (courseF.getStudents().size() > 50) {
			throw new MyException ("Error: Max capacity in this course (50).");
		}
		insertStudent(courseF.getStudents(), studentF);
	}


	@Override
	public void cancel(Student student, Course course) throws MyException {
		if (this.students == null || this.courses == null || student == null || course == null) {
			throw new MyException("Error: Cannot be null.");
		}
		
		if (this.students.isEmpty() || this.courses.isEmpty()) {
			throw new MyException("Error: Empty list.");
		}

		if (this.students.contains(student)) {
			if (this.courses.contains(course)) {
				if (this.courses.get(this.courses.indexOf(course)).getStudents().contains(student)) {
					this.courses.get(this.courses.indexOf(course)).getStudents().remove(student);
				}
				else {
					throw new MyException("Error: This student is not matriculated in this course.");
				}
			}
			else {
				throw new MyException("Error: Course not in the system.");
			}
		}
		else {
			throw new MyException("Error: Student not in the system.");
		}
	}

	@Override
	public void restarted(Course course) throws MyException {
		if (course.toString()==null)
			throw new MyException("Error: has not entered course");
		if(this.courses.isEmpty())
			throw new MyException("Error:Course list is empty");
		if(this.courses.contains(course))
		{
			while(!this.courses.get(this.courses.indexOf(course)).getStudents().isEmpty())
				cancel(this.courses.get(this.courses.indexOf(course)).getStudents().get(0), this.courses.get(this.courses.indexOf(course)));
		}
		else
			throw new MyException ("Error: Course not exist");
	}

	@Override
	public List<Student> listStudentsInCourse(int code) throws MyException {
		Course coursesR = null;
		List<Student> s;
		if (code == 0)
			throw new MyException ("Error: Invalid code");
		if (this.courses.isEmpty())
			throw new MyException ("Error: Course_List is empty");
		for (Course c:this.courses) {
			if (c.getCode()==code)
			{
				coursesR=c;
				break;
			}
			
		}
		if (coursesR==null)
			throw new MyException ("Error: Course not in the system");
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
