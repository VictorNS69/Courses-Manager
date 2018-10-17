package es.upm.pproject.tdd;

import java.util.*;

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
	 * @throws Exception
	 */
	public void new_course(int code, String name, String coordinator) throws Exception;

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
	 * @throws Exception
	 */
	public void new_student(int id, String name, String email) throws Exception;
	
	/**The system can enroll a student in a course, by using the identification number 
	 * of the student and the course code. The following restrictions must be checked 
	 * and an a proper exception must be thrown when they are not satisfied:
	 *	-The student must be registered in the system.
	 *	-The course must be registered in the system.
	 *	-A course could have, at most, 50 students matriculated.
	 *	-A student cannot be enrolled in the same course twice
	 * @param id
	 * @param course_cod
	 * @throws Exception
	 */
	public void enroll_student(int id, int course_cod) throws Exception;
	
	
	public void cancel (Student student, Course course) throws Exception;
	public void restarted (Course course) throws Exception;
	public ArrayList <Student> list_students_in_course(int code) throws Exception;
	public ArrayList <Student> list_users();
	public ArrayList <Course> list_courses();
}
