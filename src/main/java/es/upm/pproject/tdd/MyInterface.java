package es.upm.pproject.tdd;

import java.util.*;
import es.upm.pproject.tdd.exceptions.*;

public interface MyInterface{

	/**A new course can be registered. The following checks must
	 * be done before registering the course and a proper exception must be thrown 
	 * when they are not satisfied:
	 *	-The course code is not duplicated in the system.
	 *	-The code, the name and the coordinator cannot be blank.
	 * 
	 * @param code
	 * @param name
	 * @param coordinator
	 * @throws InvalidInputArgumentException, DuplicatedException
	 */
	public void newCourse(int code, String name, String coordinator) throws InvalidInputArgumentException, DuplicatedException;

	/**A new student can be registered. The following checks must be done before 
	 * registering the student an a proper exception must be thrown when they are not 
	 * satisfied:
	 * 	-The identification number is not duplicated in the system.
	 *	-The identification number, the name and the email cannot be blank.
	 *	-The format of the email address must be correct, that is, it must contain the 
	 *	character ’@’ and it cannot end in the character ’.’.
	 * @param id
	 * @param name
	 * @param email
	 * @throws InvalidInputArgumentException, DuplicatedException
	 */
	public void newStudent(int id, String name, String email) throws InvalidInputArgumentException, DuplicatedException;
	
	/**The system can enroll a student in a course, by using the identification number 
	 * of the student and the course code. The following restrictions must be checked 
	 * and an a proper exception must be thrown when they are not satisfied:
	 *	-The student must be registered in the system.
	 *	-The course must be registered in the system.
	 *	-A course could have, at most, 50 students matriculated.
	 *	-A student cannot be enrolled in the same course twice
	 * @param id
	 * @param course_cod
	 * @throws NotInTheSystemException, AlreadyInTheSystemException, MaxCapacityException, 
	 * 		InvalidInputArgumentException, DuplicatedException 
	 */
	public void enrollStudent(int id, int courseCod) throws NotInTheSystemException, AlreadyInTheSystemException, 
				MaxCapacityException, InvalidInputArgumentException, DuplicatedException ;
	
	/** The student can cancel its enrollment in a course. The system must 
	 * check if the student is registered in the system and matriculated 
	 * in the course and throws an exception when it does not happen.
	 * @param student
	 * @param course
	 * @throws InvalidInputArgumentException, EmptyListException, NotInTheSystemException
	 */
	public void cancel (Student student, Course course) throws InvalidInputArgumentException, EmptyListException, 
				NotInTheSystemException;
	
	/** A course can be restarted and this operation must remove all students
	 *  matriculated in the course. If the course code does not exist the system 
	 *  must throw an exception. 
	 * @param course
	 * @throws InvalidInputArgumentException, EmptyListException, NotInTheSystemException
	 */
	public void restarted (Course course) throws InvalidInputArgumentException, EmptyListException, 
					NotInTheSystemException;
	
	/** Given a course code, the system must return the list of matriculated students, 
	 * returning its identification number, name and surname. The list must be sorted 
	 * by the identification number. If the course code does not exist the system must 
	 * throw an exception.
	 * @param code
	 * @return List <Student> 
	 * @throws InvalidInputArgumentException, EmptyListException, NotInTheSystemException
	 */
	public List <Student> listStudentsInCourse(int code) throws InvalidInputArgumentException, EmptyListException, 
					NotInTheSystemException;
	
	/** The list of all users registered in the system, including its name, email 
	 * and identification number, can be obtained. The list must be ordered by its name
	 * @return List <Student> 
	 */
	public List <Student> listUsers();
	
	/** The list of all courses, sorted by their code, can be obtained.
	 * @return List <Course> 
	 */
	public List <Course> listCourses();
}
