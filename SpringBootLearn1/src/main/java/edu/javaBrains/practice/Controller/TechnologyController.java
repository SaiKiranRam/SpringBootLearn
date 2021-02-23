package edu.javaBrains.practice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.javaBrains.practice.entity.Programmer;
import edu.javaBrains.practice.entity.Technology;
import edu.javaBrains.practice.services.ProgrammerService;
import edu.javaBrains.practice.services.TechnologyService;

@RestController
public class TechnologyController {

	@Autowired
	ProgrammerService ps;
	
	@Autowired
	TechnologyService ts;
	
	@GetMapping("/{id}/tech")
	public List<Technology> getTechnologies(@PathVariable int id) {
		return ts.allTechnologies(id);
	}
	
	
	@PutMapping("/{id}/tech")
	public void addTechnology(@RequestBody Technology tch , @PathVariable int id) {
		
		Programmer pr = ps.programmerById(id);
		
		if(ps.programmerById(id) != null) {

			pr.getTechnologies().add(tch);
			ps.saveProgrammer(pr);
		}
		
	}
	
	@PostMapping("/{id}/tech")
	public void updateTechnology(@RequestBody Technology tch , @PathVariable int id) {
		
		ts.saveTechnology(id, tch);
	}
	
	@DeleteMapping("/{id}/tech/{techno}")
	public void deleteOneTech(@PathVariable int id, @PathVariable String techno) {

		ts.deleteTechnology(id, techno);
	}
	
	@DeleteMapping("/{id}/allTech")
	public void deleteAllTech(@PathVariable int id) {

		ts.deleteAllTechById(id);
	}
}
