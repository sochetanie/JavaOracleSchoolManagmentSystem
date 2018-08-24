package systemsInterfaces;

import java.sql.SQLException;
import java.util.*;
import models.*;

public interface TeachingDAOIand {
	
	public int assignInstructorToCourse(int course_id, int instructor_id) throws SQLException;
	
	public List<Teaching> getIntructorsCourses() throws SQLException;

}


