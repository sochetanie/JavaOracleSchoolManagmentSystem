package systemsInterfaces;

import java.sql.SQLException;
import java.util.*;
import models.Instructor;

public interface InstructorDAOI {
	
	public List<Instructor> getAllInstructors() throws SQLException;
	
	public Instructor getInstructorByGmail(String email) throws SQLException;

}
