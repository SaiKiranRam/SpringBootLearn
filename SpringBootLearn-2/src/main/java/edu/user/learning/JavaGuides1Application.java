package edu.user.learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaGuides1Application {

    static final Logger logger = LogManager.getLogger(JavaGuides1Application.class);
	
	public static void main(String[] args) {
		logger.info("Starting the application.................");
		SpringApplication.run(JavaGuides1Application.class, args);
	}

}
