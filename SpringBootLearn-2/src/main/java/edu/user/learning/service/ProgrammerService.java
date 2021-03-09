package edu.user.learning.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.user.learning.entity.Programmer;
import edu.user.learning.exceptions.ResourceNotFoundException;
import edu.user.learning.repository.ProgrammerRepository;
import edu.user.learning.repository.TechnologyRepository;

@Service
public class ProgrammerService {
	
    final Logger logger = LogManager.getLogger(this.getClass());
    final String className = "[" + this.getClass().toString() + "]";
    
	@Autowired
	ProgrammerRepository pr;
	
	@Autowired
	TechnologyRepository tr;

	public List<Programmer> getAllProgrammers() {
		
		logger.info(className + " -- Attempting to get all programmers");
		
		return pr.findAll();
	}

	public Programmer addProgrammer(Programmer programmer) {
		
		logger.info(className + " -- Adding a new programmer: " + programmer);
		
		return pr.save(programmer);
	}

	public Programmer updateProgrammer(Programmer programmer, long id) {
		
		logger.info(className + " -- Updating a programmer: " + programmer);
		
		Programmer existingProg =
				pr.findById(id).orElse(null);
		
		if(existingProg.equals(null))
			throw new ResourceNotFoundException("Programmer with ID: " + id + " not found!");
		
		existingProg.setFirstName(programmer.getFirstName());
		existingProg.setLastName(programmer.getLastName());
		existingProg.setTechnologies(programmer.getTechnologies());
		
		return pr.save(existingProg);
	}

	public void deleteProgrammer(long id) {

		logger.info(className + " -- Do we have a programmer with given id- " + id + ": " + pr.existsById(id));
		
		if(pr.existsById(id)) {

			pr.deleteById(id);
			
			logger.info(className + " -- Programmer " + id + " is deleted");
			
			return;
		}
		
		throw new ResourceNotFoundException("Programmer with id " + id + " does not exist!");
	}

	public Programmer getProgrammerById(long id) {

		return pr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cannot find Programmer with ID: " + id));
	}
	
}
