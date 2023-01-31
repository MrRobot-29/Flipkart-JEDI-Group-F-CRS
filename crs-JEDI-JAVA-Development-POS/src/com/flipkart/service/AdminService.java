package com.flipkart.service;

public interface AdminService {
	
	public void dropCourse(String courseCode);

    public void addCourse(String courseCode);

    public void assignCourse(String courseCode, String professorId);

    public void viewCourses(String catalogId);

// student related services

    public void viewPendingStudents();

    public void viewAllStudents();

    public void validateStudent(String studentId);


// professor related services

    public void addProfessor(String professorId);

    public void dropProfessor(String professorId);
    
    public void viewProfessors();


    // gradecard related services
    public void generateGradeCard(String studentId, String semester);

}