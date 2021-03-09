package edu.user.learning.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.user.learning.entity.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {

//	List<Technology> findByProg_Id(long id);

	
}
