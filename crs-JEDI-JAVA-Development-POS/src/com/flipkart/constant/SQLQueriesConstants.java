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
	
	public static final String last_id="SELECT MAX(Student.student_id) FROM crs_db.Student";
	
	
	
	
	public static final String VIEW_REGISTERED_COURSES=" select * from course inner join registeredcourse on course.courseCode = registeredcourse.courseCode where registeredcourse.studentId = ?";
	public static final String VIEW_AVAILABLE_COURSES=" select * from course where courseCode not in  (select courseCode  from registeredcourse where studentId = ?) and course.isOffered = ? and seats > 0";
	public static final String CHECK_COURSE_AVAILABILITY=" select courseCode from registeredcourse where studentId = ? ";
	public static final String DECREMENT_COURSE_SEATS="update course set seats = seats-1 where courseCode = ? ";
	public static final String ADD_COURSE="insert into registeredcourse (studentId,courseCode) values ( ? , ? )";
	public static final String DROP_COURSE_QUERY = "delete from registeredcourse where courseCode = ? AND studentId = ?;";
	public static final String INCREMENT_SEAT_QUERY  = "update course set seats = seats + 1 where  courseCode = ?;";
	public static final String CALCULATE_FEES  = "select sum(courseFee) from course where courseCode in (select courseCode from registeredcourse where studentId = ?);";
	public static final String VIEW_GRADE = "select course.courseCode,course.courseName,registeredcourse.grade from course inner join registeredcourse on course.courseCode = registeredcourse.courseCode where registeredcourse.studentId = ?;";	
	public static final String GET_SEATS = "select seats from course where courseCode = ?;";
	public static final String INSERT_PAYMENT = "insert into payment(studentId,modeofPayment,referenceId,amount) values(?,?,?,?);";
	public static final String INSERT_NOTIFICATION = "insert into notification(studentId,type,referenceId) values(?,?,?);";
	public static final String GET_NOTIFICATION = "select * from notification where referenceId = ?;";
	public static final String ADD_GRADE="update registeredcourse set Grade=? where courseCode=? and studentId=?";
	public static final String GET_COURSES="select * from course where professorId=?";
	public static final String GET_REGISTRATION_STATUS=" select isRegistered from student where studentId = ? ";
	public static final String SET_REGISTRATION_STATUS="update student set isRegistered = true  where studentId=?";
	public static final String GET_ENROLLED_STUDENTS="select course.courseCode,course.courseName,registeredcourse.studentId from course inner join registeredcourse on course.courseCode = registeredcourse.courseCode where course.professorId = ? order by course.courseCode";
	public static final String NUMBER_OF_REGISTERED_COURSES=" select studentId from registeredcourse where studentId = ? ";
	public static final String IS_REGISTERED=" select courseCode from registeredcourse where courseCode=? and studentId=? ";
	
}