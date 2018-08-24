package dao;

import java.sql.*;
import java.util.*;
import dao.SqlQueries.SQL;
import models.*;
import systemsInterfaces.CourseDAOI;

public class CourseDAO implements CourseDAOI {

	public List<Course> getAllCourses() {
		Connection conn = null;
		
		List<Course> courses = new ArrayList<Course>();
		
		try {
			OracleConnection c = new OracleConnection();
			conn = c.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL.getAllCourses.getQuery());
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				Course course = new Course();
				course.setCourse_id(result.getInt(1));
				course.setCourse_name(result.getString(2));
				course.setMinimum_gpa(result.getDouble(3));
				courses.add(course);
			}
			
		} 
		catch (Exception e) {  e.printStackTrace();  }
		
		return courses;
	}


	public List<Course> getCourseByInstructor(int instructor_id) {
		Connection conn = null;
		
		List<Course> courses = new ArrayList<Course>();
		
		try {
			OracleConnection c = new OracleConnection();
			conn = c.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL.getCourseByInstructor.getQuery());
			ps.setInt(1, instructor_id);
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				Course course = new Course();
				course.setCourse_id(result.getInt(1));
				course.setCourse_name(result.getString(2));
				course.setMinimum_gpa(result.getDouble(3));
				courses.add(course);
			}
			
		} 
		catch (Exception e) { e.printStackTrace(); }

		return courses;
	}


}




