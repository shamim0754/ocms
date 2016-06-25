package com.deltagroupbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

//for bootstrap the Spring application since there is no web.xml 
@SpringBootApplication
public class AppInitializer extends SpringBootServletInitializer{
	   
   /**
    * Enable to create deployable war file
    */
	  @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppInitializer.class);
    }
	
}
