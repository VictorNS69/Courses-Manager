package es.upm.pproject.tdd;

import java.util.*;
import java.util.zip.DataFormatException;

public class Course{
  private int code;
  private String name;
  private String coordinator;
  private ArrayList <Student> students;

  public Course (int code, String name, String coordinator)  throws DataFormatException{
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
  public ArrayList<Student> getStudents(){
    return this.students;
  }
}
