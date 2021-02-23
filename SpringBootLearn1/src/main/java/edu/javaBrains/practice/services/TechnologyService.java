package edu.javaBrains.practice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.javaBrains.practice.entity.Programmer;
import edu.javaBrains.practice.entity.ProgrammerDAO;
import edu.javaBrains.practice.entity.Technology;
import edu.javaBrains.practice.entity.TechnologyDAO;

@Service
public class TechnologyService {

	@Autowired
	TechnologyDAO td;

	@Autowired
	ProgrammerDAO pd;
	
	public List<Technology> allTechnologies(int id) {

		return td.findByProg_Id(id);
	}

	public void saveTechnology(int id, Technology tch) {

		if(pd.existsById(id)) {		//	Check if the prog exists
			
			Technology test = td.findByProgAndTech(id, tch.getTechno());
			
			if(test != null) { //	Check if provided tech already exists for that prog

				td.updateById(test.gettId(), tch.getTechno(), tch.getExp(), tch.getSpecialization());
				
				return;
			}
			else {	// If tech already isn't present then add the tech
				Programmer pr = pd.findById(id).orElse(null);
				
				pr.getTechnologies().add(tch);
				
				pd.deleteById(id);
				pd.save(pr);
			}
		}
	}

	public void deleteTechnology(int id, String techno) {

//		allTechnologies(id)
//			.forEach(t -> {
//								if(t.getTechno().equals(techno))
//									td.delete(t);
//					});
		
		if(td.findByProgAndTech(id, techno) != null)
			td.deleteByTechAndProg_id(id, techno);
	}

	public void deleteAllTechById(int id) {

		td.deleteByProg_id(id);
	}
	
}
