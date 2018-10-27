package es.upm.pproject.tdd;

public class Student{
	private int id;
	private String name;
	private String email;

	public Student (int id, String name, String email){
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getId(){
		return this.id;
	}

	public String getName(){
		return this.name;
	}

	public String getEmail(){
		return this.email;
	}

	public String toString() {
		return "[" + this.getId() +", " + this.getName() +", "+ this.getEmail()+"]";
	}
}
