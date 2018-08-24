package systemsInterfaces;

import java.sql.SQLException;
import java.util.*;
import models.Course;

public interface CourseDAOI {
	
	public List<Course> getAllCourses() throws SQLException;
	
	public List<Course> getCourseByInstructor(int instructor_id) throws SQLException;
	
}


