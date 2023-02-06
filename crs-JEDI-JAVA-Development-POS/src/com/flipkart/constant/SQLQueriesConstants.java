package com.flipkart.constant;
/**
 * 
 * @author JEDI-03
 *
 */

public class SQLQueriesConstants {
	
	
	// Student Queries
	
	public static final String IS_APPROVED="SELECT Student.approval_status FROM crs_db.Student WHERE Student.student_id= ?";
	public static final String GET_TOTAL_STUDENTS="SELECT ";
	public static final String GET_STUDENT_ID="SELECT Student.student_id FROM crs_db.Student WHERE Student.email= ?";
	public static final String GET_CURR_SEM="SELECT Student.semester FROM crs_db.Student WHERE Student.student_id= ?";
	
	public static final String ADD_STUDENT="INSERT INTO `crs_db`.`User`(`email`,`name`,`role`,`password`) VALUES ( ? , ? , \"student\" , ? )";
	
	public static final String ADD_STUDENT_ID="INSERT INTO `crs_db`.`Student` (`student_id`, `email`, `approval_status`, `branch`, `semester`) VALUES ( ? , ? , 0 , ? , ?)";
	
	public static final String LAST_ID="SELECT MAX(Student.student_id) FROM crs_db.Student";
	
	public static final String GET_COURSE_ID="SELECT RegisteredCourse.course_id FROM RegisteredCourse WHERE RegisteredCourse.student_id= ? AND RegisteredCourse.registration_status=2";
	//public static final String GET_COURSE_NAME="SELECT Course.course_name in Course WHERE Course.course_id IN ?";
	
	public static final String GET_COURSES="SELECT * FROM Course WHERE Course.semester= ?";
	
	public static final String COUNT_CURRENT_COURSE_SEATS="SELECT COUNT(student_id) FROM RegisteredCourse WHERE course_id= ?";
	
	public static final String ADD_COURSE_IN_BUCKET="INSERT INTO `crs_db`.`RegisteredCourse` (`student_id`, `course_id`, `grade`, `registration_status`) VALUES (?, ?, \"GA\", ?)";
	
	public static final String DROP_COURSE="DELETE FROM crs_db.RegisteredCourse WHERE RegisteredCourse.course_id= ? AND RegisteredCourse.student_id= ?";
	
	public static final String PRIMARY_COURSE_FREQ="SELECT COUNT(course_id) FROM crs_db.RegisteredCourse WHERE RegisteredCourse.student_id= ? AND RegisteredCourse.registration_status = 0";
	
	public static final String SECONDARY_COURSE_FREQ="SELECT COUNT(course_id) FROM crs_db.RegisteredCourse WHERE RegisteredCourse.student_id= ? AND RegisteredCourse.registration_status = 1";
	
}