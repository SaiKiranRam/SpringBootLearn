package edu.user.learning.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.user.learning.entity.Programmer;
import edu.user.learning.service.ProgrammerService;

@RestController
public class ProgrammerController {
	
    final Logger logger = LogManager.getLogger(this.getClass());
    final String className = "[" + this.getClass().toString() + "]";
    
	@Autowired
	ProgrammerService ps;
	
	@GetMapping("/")
	public List<Programmer> getProgrammers() {
		
		logger.info(className + " -- Attempting for getAllProgrammers() in ProgrammerService");
		
		return ps.getAllProgrammers();
	}
	
	@GetMapping("/{id}")
	public Programmer getProgrammer(@PathVariable long id) {

		logger.info(className + " -- Attempting to get programmer of ID: " + id);
		
		return ps.getProgrammerById(id);
	}
	
	@PostMapping("/")
	public Programmer addProgrammer(@RequestBody Programmer programmer) {

		logger.info(className + " -- Adding a programmer: " + programmer.toString());
		
		return ps.addProgrammer(programmer);
	}
	
	@PutMapping("/{id}")
	public Programmer updateProgrammer(@RequestBody Programmer programmer, @PathVariable long id) {

		logger.info(className + " -- Updating a programmer of Id: " + id + " with details:\n" +programmer.toString());
		
		return ps.updateProgrammer(programmer, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProgrammer(@PathVariable long id) {

		logger.info(className + " -- Attempting to delete a programmer of ID: " + id);
		
		ps.deleteProgrammer(id);
	}
}
