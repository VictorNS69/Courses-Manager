package es.upm.pproject.tdd;

import java.util.*;

public class Course{
  private int code;
  private String name;
  private String coordinator;
  private List <Student> students;
  
  public Course (int code, String name, String coordinator){
    this.code = code;
    this.name = name;
    this.coordinator = coordinator;
    this.students = new ArrayList <Student>();
  }
  
  public int getCode(){
    return this.code;
  }
  
  public String getName(){
    return this.name;
  }
  
  public String getCoordinator(){
    return this.coordinator;
  }
  
  public List<Student> getStudents(){
    return this.students;
  }
  
  public String toString() {
	  return "["+ this.getCode() +", "+ this.getName() + ", " + this.getCoordinator() +"]";
  }
}
