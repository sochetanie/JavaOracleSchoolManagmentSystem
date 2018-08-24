package models;

public class Student {
	private int student_id, student_role = -1;
	private String full_name, email, pass;
	private Double gpa;
	
	public Student(int student_id, int student_role, String full_name, String email, String pass, Double gpa) {
		this.student_id = student_id;
		this.student_role = student_role;
		this.full_name = full_name;
		this.email = email;
		this.pass = pass;
		this.gpa = gpa;
	}

	public Student() {}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getStudent_role() {
		return student_role;
	}

	public void setStudent_role(int student_role) {
		this.student_role = student_role;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	
	
}


