package models;

public class Instructor {
	private int instructor_id, admin_role; 
	private String full_name, email, speciality, pass;
	
	public Instructor(int instructor_id, int admin_role, String full_name, String email, String speciality,
			String pass) {
		this.instructor_id = instructor_id;
		this.admin_role = admin_role;
		this.full_name = full_name;
		this.email = email;
		this.speciality = speciality;
		this.pass = pass;
	}

	public Instructor() {}
	

	public int getInstructor_id() {
		return instructor_id;
	}

	public void setInstructor_id(int instructor_id) {
		this.instructor_id = instructor_id;
	}

	public int getAdmin_role() {
		return admin_role;
	}

	public void setAdmin_role(int admin_role) {
		this.admin_role = admin_role;
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

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


	
}
