package com.flipkart.controller;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import com.flipkart.bean.*;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.data.SharedTempData;
import com.flipkart.data.TempData;
import com.flipkart.exception.*;
import com.flipkart.service.PaymentService;
import com.flipkart.service.PaymentServiceOperation;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;



@Path("/student")
@Produces(MediaType.APPLICATION_JSON)

public class StudentRestAPI {


    private final Validator validator;

    public StudentRestAPI(Validator validator) {
        this.validator = validator;
    }

    StudentDaoInterface studentDao = new StudentDaoImpl();

    static TempData td = SharedTempData.td;

    @GET
    @Path("/courseList")
    public ArrayList<Course> courseList(int sem) {
        // get the list of all the courses and return it.
        ArrayList<Course> crs =  studentDao.courseList(sem);
        return crs;
    }


    @GET
    @Path("/isCourseAvailable/{id}")
    public boolean getCourseAvailabilityStatus(@PathParam("id") String courseId) {
        return studentDao.getCourseAvailabilityStatus(courseId);
    }

    @POST
    @Path("/addCourse")
    @Consumes("application/json")
    public Response addCourse(int student_id, String course_id, int course_type) throws URISyntaxException {
        // add the course

        try {
            studentDao.addCourseBucket(student_id, course_id, course_type);
            return Response.ok().entity("Course Added Successfully").build();
        }
        catch(CourseAlreadyOptedException e){
            return Response.status(400).entity("Course Already taken").build();
        } catch (CourseNotAvailableException e) {
            return Response.status(404).entity("Course Not Available").build();
        } catch (CourseCountExceededException e) {
            return Response.status(400).entity("Course Count Exceeded").build();
        }
    }


    @GET
    @Path("/primaryCourseFreq")
    public int primaryCourseFreq(int student_id) {
        // add the course
        return studentDao.primaryCourseFreq(student_id);

    }

    @GET
    @Path("/secondaryCourseFreq")
    public int secondaryCourseFreq(int student_id) {
        // add the course
        return studentDao.secondaryCourseFreq(student_id);

    }


    @POST
    @Path("/dropCourse")
    @Consumes("application/json")
    public Response dropCourse(int student, String courseId) throws URISyntaxException  {
        // drop the course
        try {
            studentDao.drop_course(student, courseId);
            return Response.ok().entity("Course Dropped Successfully").build();
        }
        catch(CourseNotOptedException e){
            return Response.status(400).entity("Course Not Opted").build();
        }
    }

    @POST
    @Path("/freezeCourseCart")
    @Consumes("application/json")
    public Response freezeCourseCart(int studentId) {
        studentDao.freezeCourses(studentId);
        return Response.ok().entity("Courses Freeze Successfully").build();
    }

    @GET
    @Path("/viewSelectedCourses/{id}")
    public ArrayList<String> viewSelectedCourses(@PathParam("id") int student_id) {
        // get the list of approved registered courses
        return studentDao.getRegisteredCourseList(student_id);
    }



    @POST
    @Path("/payFee")
    @Consumes("application/json")
    public Response payFee(Student std) {
        double amt = studentDao.calculate_total_fee(std.getStudentID());
        PaymentService pso = new PaymentServiceOperation();
        try {
            pso.initiatePayment(amt, std, studentDao.getRegisteredCourseList(std.getStudentID()));
            return Response.ok().entity("Payment Successful").build();
        } catch (PaymentNotCompletedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return Response.status(400).entity("Payment unsuccessful ").build();
        }
    }

    @POST
    @Path("/add_drop_status")
    @Consumes("application/json")
    public boolean add_drop_status(int studentId) {
        int cnt = studentDao.countFreezeCourses(studentId);
        if(cnt >= 4) {
            return false;
        }
        return true;
    }

    @GET
    @Path("/viewGrade")
    public HashMap<String,String> viewGrade(@PathParam("id") int studentId, @PathParam("sem") int sem) {
        //view the grade card with exception handling
        return studentDao.viewGrade(studentId, sem);
    }

    @GET
    @Path("/checkCourse")
    public Response checkCourse(@PathParam("studentId") int studentId, @PathParam("courseId") String courseId) throws CourseAlreadyOptedException
    {
        try {
            boolean msg = studentDao.checkCourse(studentId, courseId);
            return Response.ok().entity(msg).build();
        }
        catch(CourseAlreadyOptedException e){
            return Response.status(400).entity("Course Already Added!!").build();
        }
    }
}
