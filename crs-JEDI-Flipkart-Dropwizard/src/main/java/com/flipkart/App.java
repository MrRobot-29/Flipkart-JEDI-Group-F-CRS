package com.flipkart;

//import com.flipkart.controller.EmployeeController;
//import com.flipkart.controller.HelloRestAPI;
import com.flipkart.controller.ProfessorRestAPI;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        System.out.println("Running app");
        //registering all the RESTful service classes.
        e.jersey().register(new ProfessorRestAPI());
//        e.jersey().register(new EmployeeController(e.getValidator()));
//        e.jersey().register(new ProfessorRestAPI());
//        e.jersey().register(new StudentRestAPI());
//        e.jersey().register(new UserRestAPI());
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}