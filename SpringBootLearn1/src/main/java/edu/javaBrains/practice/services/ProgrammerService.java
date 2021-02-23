package edu.javaBrains.practice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.javaBrains.practice.entity.Programmer;
import edu.javaBrains.practice.entity.ProgrammerDAO;
import edu.javaBrains.practice.entity.TechnologyDAO;

@Service
public class ProgrammerService {

	@Autowired
	ProgrammerDAO pd;
	
	@Autowired
	TechnologyDAO td;
	
	public List<Programmer> allProgrammers() {

		return (List<Programmer>) pd.findAll();
	}

	public Programmer programmerById(int id) {

		return pd.findById(id).orElse(null);
	}

	public void saveProgrammer(Programmer prog) {

		pd.save(prog);
		return;
	}

	public void deleteProgrammer(int id) {

//		First delete associated technologies of a programmer, then deleting the programmer
		
		if(pd.existsById(id)) {

			if(!td.findByProg_Id(id).isEmpty())
				td.deleteByProg_id(id);
			pd.deleteById(id);
		}
		return;
	}

}
