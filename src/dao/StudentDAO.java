package dao;

import java.sql.*;

import dao.SqlQueries.SQL;
import models.Student;
import systemsInterfaces.StudentDAOI;

public class StudentDAO extends OracleConnection implements StudentDAOI {
	
	public Student getStudentByGmail(String email) {
		Connection conn = null;
		
		Student student = new Student();
		
		try {
			OracleConnection c = new OracleConnection();
			conn = c.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL.getStudentByGmail.getQuery());
			ps.setString(1, email);
			ResultSet result = ps.executeQuery();
			
			if (result.next()) {
				student.setStudent_id(result.getInt(1));
				student.setFull_name(result.getString(2));
				student.setEmail(result.getString(3));
				student.setGpa(result.getDouble(4));
				student.setPass(result.getString(5));
				student.setStudent_role(result.getInt(6));
			}
			
		} 
		catch (Exception e) { e.printStackTrace(); }
		
		return student;
	}


	public boolean validateUser(String passToValidate, String comparablePas) {
		return passToValidate.equals(comparablePas);
	}
	
	
	
}
