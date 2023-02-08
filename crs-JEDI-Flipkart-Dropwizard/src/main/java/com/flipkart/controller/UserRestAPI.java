package com.flipkart.controller;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.LoginCredential;
import com.flipkart.bean.ResponseMessage;
import com.flipkart.bean.Student;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.exception.WrongPasswordException;
import com.flipkart.service.UserServiceOperation;
import org.hibernate.validator.constraints.Email;

@Path("/user")
public class UserRestAPI {

    UserServiceOperation uso = new UserServiceOperation();

    private final Validator validator;

    public UserRestAPI(Validator validator) {
        this.validator = validator;
    }
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginAccount(@Valid LoginCredential lg) throws ValidationException {
        try
        {
            boolean loggedIn= uso.loginAccount(lg.getUserId(), lg.getPassword(), lg.getRole());
            if(loggedIn)
            {
                ResponseMessage rs = new ResponseMessage("Login successful");
                return Response.status(200).entity(rs).build();
            }
            else
            {
                ResponseMessage rs = new ResponseMessage("Invalid credentials!");
                return Response.status(401).entity(rs).build();
            }
        }
        catch ( UserNotFoundException | WrongPasswordException e)
        {
            ResponseMessage rs = new ResponseMessage(e.getMessage());
            return Response.status(500).entity(rs).build();
        }
    }

    @POST
    @Path("/studentRegistration")
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(@Valid Student student)
    {
        try
        {
            uso.registerAccount(student);
            ResponseMessage rs = new ResponseMessage("Student registration successful");
            return Response.ok().entity(rs).build();
        }
        catch(Exception ex)
        {
            ResponseMessage rs = new ResponseMessage("Something went wrong! Please try again.");
            return Response.status(500).entity(rs).build();
        }
    }
}
