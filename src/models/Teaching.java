package models;

public class Teaching {
	private String course_name, full_name, email;
	private Double minimum_gpa;
	
	
	public Teaching(String course_name, String full_name, String email, Double minimum_gpa) {
		this.course_name = course_name;
		this.full_name = full_name;
		this.email = email;
		this.minimum_gpa = minimum_gpa;
	}

	public Teaching() {}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
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

	public Double getMinimum_gpa() {
		return minimum_gpa;
	}

	public void setMinimum_gpa(Double minimum_gpa) {
		this.minimum_gpa = minimum_gpa;
	}
	

}
