package com.flipkart.controller;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.LoginCredential;
import com.flipkart.bean.Student;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.exception.WrongPasswordException;
import com.flipkart.service.UserServiceOperation;
import org.hibernate.validator.constraints.Email;

@Path("/user")
public class UserRestAPI {

    UserServiceOperation uso = new UserServiceOperation();

    @POST
    @Path("/login")
    public Response loginAccount(@Valid LoginCredential lg) throws ValidationException {
        try
        {
            boolean loggedin= uso.loginAccount(lg.getUserId(), lg.getPassword(), lg.getRole());
            if(loggedin)
            {
                return Response.status(200).entity("Login successful").build();
            }
            else
            {
                return Response.status(401).entity("Invalid credentials!").build();
            }
        }
        catch ( UserNotFoundException | WrongPasswordException e)
        {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/studentRegistration")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(@Valid Student student)
    {
        try
        {
            uso.registerAccount(student);
            return Response.ok().entity("Student registration successful").build();
        }
        catch(Exception ex)
        {
            return Response.status(500).entity("Something went wrong! Please try again.").build();
        }
    }
}
