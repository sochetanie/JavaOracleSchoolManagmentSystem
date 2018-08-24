package systemsInterfaces;

import java.sql.SQLException;

import models.Student;

public interface StudentDAOI {
	
	public Student getStudentByGmail(String email) throws SQLException;

}
