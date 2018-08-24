package dao;

import java.sql.*;
import java.util.*;
import customExceptions.StudentRegistrationException;
import dao.SqlQueries.SQL;
import models.*;
import systemsInterfaces.AttendingDAOI;

public class AttendingDAO implements AttendingDAOI {
	
	public int registerStudentToCourse(Student student, Course course) {
		Connection conn = null;
		
		int key = 0;
		try {
			if(student.getGpa() < course.getMinimum_gpa()) {
				throw new StudentRegistrationException("\nDid not meet minimum GPA requirement\nRegistration Denied");
			}
			
			OracleConnection c = new OracleConnection();
			conn = c.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL.checkStudentCourcesForInputCourceID.getQuery());
			ps.setInt(1, course.getCourse_id());
			ps.setInt(2, student.getStudent_id());
			ResultSet result = ps.executeQuery();
			
			if(result.next()) {
				conn.close();
				throw new StudentRegistrationException("Student is already registered for that course!");
			}
			else {
				ps = conn.prepareStatement(SQL.registerStudentToCourse.getQuery());
				ps.setInt(1, course.getCourse_id());
				ps.setInt(2, student.getStudent_id());
				ps.executeUpdate();
			}
			
			result = ps.getGeneratedKeys();
			if(result.next()) {
				key = result.getInt(1);
			}
			
		} 
		catch (Exception e) {  e.printStackTrace(); }

		
		return key;
	}
	

	@Override
	public List<Attending> getStudentCourse(int student_id) {
		Connection conn = null;
		
		List<Attending> coursesAttending = new ArrayList<Attending>();
		
		try {
			OracleConnection c = new OracleConnection();
			conn = c.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL.getStudentCourse.getQuery());
			ps.setInt(1, student_id);
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				Attending attending = new Attending();
				attending.setCourse_name(result.getString(1));
				attending.setEmail(result.getString(3));
				attending.setFull_name(result.getString(2));
				coursesAttending.add(attending);
			}
			
		}
		catch (Exception e) { e.printStackTrace(); }

		return coursesAttending;
	}

}





