package dao;

public class SqlQueries {
	
	enum SQL {
		getStudentByGmail("SELECT * FROM student WHERE email=?"),
		assignInstructorToCourse("INSERT INTO Teaching(course_id, instructor_id) VALUES(?,?)"),
		checkInstructorCourcesForInputCourceID("SELECT * FROM TEACHING WHERE COURSE_ID=? AND INSTRUCTOR_ID=?"),
	
		getAllInstructors("SELECT * FROM instructor"),
		getInstructorByGmail("SELECT * FROM instructor WHERE email=?"),
		
		getIntructorsCourses("SELECT c.COURSE_NAME, c.MINIMUN_GPA, i.FULL_NAME, i.EMAIL FROM INSTRUCTOR i JOIN TEACHING t ON t.INSTRUCTOR_ID = i.INSTRUCTOR_ID JOIN COURSE c ON c.COURSE_ID = t.COURSE_ID"),
		
		getAllCourses("SELECT * FROM course"),
		getCourseByInstructor("SELECT c.COURSE_ID, c.COURSE_NAME, c.MINIMUN_GPA FROM COURSE c JOIN TEACHING t ON c.COURSE_ID = t.COURSE_ID WHERE INSTRUCTOR_ID=?"),
		
		checkStudentCourcesForInputCourceID("SELECT * FROM attending WHERE course_id = ? AND student_id=?"),
		registerStudentToCourse("INSERT INTO attending(course_id,student_id) VALUES(?,?)"),
		
		getStudentCourse("SELECT c.COURSE_NAME, i.FULL_NAME, i.EMAIL FROM ATTENDING a JOIN COURSE c ON a.COURSE_ID = c.COURSE_ID JOIN TEACHING t ON a.COURSE_ID = t.COURSE_ID JOIN INSTRUCTOR i ON t.INSTRUCTOR_ID = i.INSTRUCTOR_ID WHERE a.STUDENT_ID=?");
		
		
		String query;
		SQL(String givenQuery) { query = givenQuery; }
		String getQuery() { return query; }
	}

}
