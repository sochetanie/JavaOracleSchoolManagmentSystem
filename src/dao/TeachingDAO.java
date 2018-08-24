package dao;

import java.sql.*;
import java.util.*;

import customExceptions.InstructorRegistrationException;
import dao.SqlQueries.SQL;
import models.Teaching;
import systemsInterfaces.TeachingDAOIand;

public class TeachingDAO implements TeachingDAOIand {

	public List<Teaching> getIntructorsCourses() {
		Connection conn = null;
		
		List<Teaching> teachings = new ArrayList<Teaching>();
		
		try {
			OracleConnection c = new OracleConnection();
			conn = c.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL.getIntructorsCourses.getQuery());
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				Teaching teaching = new Teaching();
				teaching.setCourse_name(result.getString("COURSE_NAME"));
				teaching.setEmail(result.getString("EMAIL"));
				teaching.setFull_name(result.getString("FULL_NAME"));
				teaching.setMinimum_gpa(result.getDouble("MINIMUN_GPA"));
				teachings.add(teaching);
			}
			
		}
		catch (Exception e) { e.printStackTrace(); }

		return teachings;
	}

	
	public int assignInstructorToCourse(int course_id, int instructor_id) {
Connection conn = null;
		
		int result = 0;
		try {
			OracleConnection c = new OracleConnection();
			conn = c.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL.checkInstructorCourcesForInputCourceID.getQuery());
			ps.setInt(1, course_id);
			ps.setInt(2, instructor_id);
			ResultSet result1 = ps.executeQuery();
			
			if(result1.next()) {
				conn.close();
				throw new InstructorRegistrationException("Instructor is already registered for that course!");
			}
			else {
			ps = conn.prepareStatement(SQL.assignInstructorToCourse.getQuery());
			ps.setInt(1, course_id);
			ps.setInt(2, instructor_id);
			result = ps.executeUpdate();
			
			}
		} 
		catch (Exception e) { e.printStackTrace(); }
		
		return result;
	}

	
}






