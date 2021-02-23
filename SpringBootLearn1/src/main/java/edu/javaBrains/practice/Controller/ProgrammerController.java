package edu.javaBrains.practice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.javaBrains.practice.entity.Programmer;
import edu.javaBrains.practice.services.ProgrammerService;

@RestController
public class ProgrammerController {

	@Autowired
	ProgrammerService ps;
	
	@Autowired
	TechnologyController tc;
	
	@GetMapping("/")
	public List<Programmer> getProgrammers() {
		
		return ps.allProgrammers();
	}
	
	
	@GetMapping("/{id}")
	public Programmer getProgrammerByID(@PathVariable int id) {
		
		return ps.programmerById(id);
	}

	@PostMapping("/{id}")
	public void saveProgrammer(@RequestBody Programmer prog , @PathVariable int id) {
		
		ps.saveProgrammer(prog);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProgrammer(@PathVariable int id) {

		ps.deleteProgrammer(id);
	}
}
