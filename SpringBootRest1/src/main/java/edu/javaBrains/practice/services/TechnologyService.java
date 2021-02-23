package edu.javaBrains.practice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.javaBrains.practice.entity.Technology;
import edu.javaBrains.practice.entity.TechnologyDAO;

@Service
public class TechnologyService {

	@Autowired
	TechnologyDAO td;
	
	public List<Technology> allTechnologies(int id) {

		return td.findByProg_Id(id);
	}

	public void saveTechnology(int id, Technology tch) {

		Technology check = td.findByProgAndTech(id, tch.getTechno());
		
		if(check.getTechno() != null) {	//	If technology exists, update the entry directly, else create
			
//			td.updateById(tch.gettId(), tch.getTechno(), tch.getExp(), tch.getSpecialization());
			
			return;
		}
		
//		check.get
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
