package systemsInterfaces;

import java.sql.SQLException;
import java.util.*;

import customExceptions.StudentRegistrationException;
import models.*;

public interface AttendingDAOI {
	
	public int registerStudentToCourse(Student student, Course course) throws SQLException, StudentRegistrationException;
	
	public List<Attending> getStudentCourse(int student_id) throws SQLException;

}
