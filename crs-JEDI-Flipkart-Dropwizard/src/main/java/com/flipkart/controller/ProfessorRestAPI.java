package com.flipkart.controller;

import com.flipkart.service.ProfessorServiceOperation;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/professor")
public class ProfessorRestAPI {

    ProfessorServiceOperation pso = new ProfessorServiceOperation();

    @GET
    @Path("/viewCouseList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> viewEnrolledStudents(
            @NotNull
            @QueryParam("profId") int profId) throws ValidationException {

        List<String> courses=new ArrayList<>();
        try
        {
            courses = pso.viewCourseList(profId);
        }
        catch(Exception ex)
        {
            return null;
        }
        return courses;
    }

    @GET
    @Path("/getEnrolledStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> viewEnrolledStudents(
            @NotNull
            @QueryParam("profId") int profId,

            @NotNull
            @QueryParam("courseId") String courseId) throws ValidationException {

        List<String> students=new ArrayList<String>();
        try
        {
            students=pso.viewEnrolledStudents(profId,courseId);
        }
        catch(Exception ex)
        {
            return null;
        }
        return students;
    }

    @POST
    @Path("/selectCourseToTeach")
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectCourseToTeach(
            @NotNull
            @QueryParam("profId") int profId,

            @NotNull
            @QueryParam("courseId") String courseId) throws ValidationException {

        boolean status = false;
        try
        {
            status = pso.selectCourseToTeach(courseId,profId);
            if(status){
                return Response.ok().entity("Course successfully opted to teach").build();
            }
            else
                return Response.status(404).entity("Action failed").build();
        }
        catch(Exception ex)
        {
            return Response.status(404).entity("Action failed").build();
        }
    }

    @POST
    @Path("/addGrade")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addGrade(
            @NotNull
            @QueryParam("studentId") int studentId,

            @NotNull
            @QueryParam("courseId") String courseId,

            @NotNull
            @QueryParam("grade") String grade) throws ValidationException {

        boolean status = false;
        try
        {
            status = pso.addGrade(courseId,studentId,grade);
            if(status){
                return Response.ok().entity("Grade alloted").build();
            }
            else
                return Response.status(404).entity("Action failed").build();
        }
        catch(Exception ex) {
            return Response.status(404).entity("Action failed").build();
        }
    }

}
