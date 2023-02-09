/**
 *
 */
package com.flipkart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.ResponseMessage;
import com.flipkart.exception.*;
import com.flipkart.service.AdminServiceOperation;
import org.eclipse.jetty.util.ajax.JSON;
import org.hibernate.validator.constraints.Email;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

/**
 * @author JEDI-03
 */
@Path("/admin")
public class AdminRestAPI {

     AdminServiceOperation aso = new AdminServiceOperation();

    private final Validator validator;

    public AdminRestAPI(Validator validator) {
        this.validator = validator;
    }


    /**
     * /admin/addProfessor
     * REST-service for adding a new professor
     * @param professor
     * @return
     */
    @POST
    @Path("/addProfessor")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProfessor(@Valid Professor professor) throws ValidationException{
        try{
            aso.addProfessor(professor);
            return  Response.ok().entity("Professor Added Successfully").build();
        } catch (ProfessorIdAlreadyExistsException pe){
            return Response.status(404).entity(pe.getMessage()).build();
        }
    }


    /**
     * /admin/dropProfessor
     * REST-service for dropping a new professor
     * @param professor_id
     * @return
     */
    @POST
    @Path("/dropProfessor")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dropProfessor(@QueryParam("profID") int professor_id) throws ValidationException{
        try{
            aso.dropProfessor(professor_id);
            return  Response.ok().entity("Professor Dropped Successfully").build();
        } catch (ProfessorCannotBeDroppedException pe){
            return Response.status(404).entity(pe.getMessage()).build();
        }
    }

    /**
     * /admin/viewPendingAdmissions
     * REST-service for getting all pending-approval of students
     * @return
     */
    @GET
    @Path("/viewPendingStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Student> viewPendingStudents() {

        try {
            return aso.viewPendingStudents();
        } catch (NoStudentFoundException e) {
            return new ArrayList<Student>();
        }

    }


    @GET
    @Path("/viewAllStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Student> viewAllStudents() {

        try {
            return aso.viewAllStudents();
        } catch (NoStudentFoundException e) {
            return new ArrayList<Student>();
        }

    }

    /**
     * /admin/approveStudent
     * REST-service for approving the student admission
     * @param studentId
     * @return
     */
    @PUT
    @Path("/approveStudent")
    @Produces(MediaType.APPLICATION_JSON)
    public Response approveStudent(
            @Min(value = 1, message = "Student ID should not be less than 1")
            @Max(value = 9999999, message = "Invalid Student ID")
            @NotNull
            @QueryParam("studentId") int studentId) throws ValidationException{

        try {

            aso.validateStudent(studentId);
            return Response.status(201).entity("Student with studentId: " + studentId + " approved").build();

        } catch (StudentNotFoundException e) {

            return Response.status(404).entity(e.getMessage()).build();

        }

    }

    /**
     * /admin/viewCoursesInCatalogue
     * REST-service for getting courses in the catalog
     * @return
     */
    @GET
    @Path("/viewCoursesInCatalogue")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Course> viewCoursesInCatalogue() {

        try {
            return aso.viewCourses();
        } catch (NoCourseFoundException e) {
            return new ArrayList<Course>();
        }

    }

    /**
     * /admin/deleteCourse
     * REST-services for dropping a course from catalog
     * @param courseCode
     * @return
     */
    @PUT
    @Path("/deleteCourse")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCourse(
            @Size(min = 2 , max = 10 , message = "Course Code length should be between 3 and 10 character")
            @NotNull
            @QueryParam("courseCode") String courseCode) throws ValidationException{
        System.out.println(courseCode);
        try {
            aso.dropCourse(courseCode);
            ResponseMessage rs = new ResponseMessage("Course with courseCode: " + courseCode + " deleted from catalog");
            return Response.status(200).entity(rs).build();

        } catch (CourseNotFoundException e) {
            ResponseMessage rs = new ResponseMessage(e.getMessage());
            return Response.status(404).entity(rs).build();
        }
    }

    /**
     * /admin/addCourse
     * REST-service for adding a new course in catalog
     * @param course
     * @return
     */
    @POST
    @Path("/addCourse")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCourse(@Valid Course course) throws ValidationException{

        try {
            aso.addCourse(course);
            ResponseMessage rs = new ResponseMessage("Course with courseCode: " + course.getCourseId() + " added to catalog");
            return Response.status(201).entity(rs).build();

        } catch ( CourseAlreadyExistsException e) {

            return Response.status(404).entity(e.getMessage()).build();

        }

    }

    /**
     *
     * @return list of professors in the system
     */
    @GET
    @Path("/viewProfessors")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Professor> viewProfessors() {

        try {
            return aso.viewProfessors();
        } catch (NoProfessorFoundException e) {
            return new ArrayList<Professor>();
        }
    }
}
	