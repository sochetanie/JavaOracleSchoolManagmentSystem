package dao;

import java.sql.*;
import java.util.*;

import dao.SqlQueries.SQL;
import models.*;
import systemsInterfaces.InstructorDAOI;


public class InstructorDAO implements InstructorDAOI {
	
	public List<Instructor> getAllInstructors() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		
		List<Instructor> instructors = new ArrayList<Instructor>();
		
		try {
			OracleConnection c = new OracleConnection();
			conn = c.getConnection();
			ps = conn.prepareStatement(SQL.getAllInstructors.getQuery());
			result = ps.executeQuery();
			
			while (result.next()) {
				Instructor instructor = new Instructor();
				instructor.setInstructor_id(result.getInt(1));
				instructor.setFull_name(result.getString(2));
				instructor.setEmail(result.getString(3));
				instructor.setSpeciality(result.getString(4));
				instructor.setAdmin_role(result.getInt(5));
				instructor.setPass(result.getString(6));
				instructors.add(instructor);
			}
			
		} 
		catch (Exception e) { e.printStackTrace(); }
		
		return instructors;
	}

	
	public Instructor getInstructorByGmail(String email) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		
		Instructor instructor = null;
		
		try {
			OracleConnection c = new OracleConnection();
			conn = c.getConnection();
			ps = conn.prepareStatement(SQL.getInstructorByGmail.getQuery());
			ps.setString(1, email);
			result = ps.executeQuery();
			
			if (result.next()) {
				instructor = new Instructor();
				instructor.setInstructor_id(result.getInt(1));
				instructor.setFull_name(result.getString(2));
				instructor.setEmail(result.getString(3));
				instructor.setSpeciality(result.getString(4));
				instructor.setAdmin_role(result.getInt(5));
				instructor.setPass(result.getString(6));
			}
			
		}
		catch (Exception e) { e.printStackTrace(); }
		
		return instructor;
	}
	
	
	public String validateUser(Instructor ins, String comparablePas) {
		if(!ins.getPass().equals(comparablePas))
			return "Wrong Credentials";
		else {
			if(ins.getAdmin_role() == 1)
				return "Admin";
			else 
				return "Instructor";
		}
	}
	

}




