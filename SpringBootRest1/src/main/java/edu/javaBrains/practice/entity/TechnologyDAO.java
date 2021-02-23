package edu.javaBrains.practice.entity;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TechnologyDAO extends CrudRepository<Technology, Integer> {

	@Query("FROM Technology WHERE prog_id=?1")
	List<Technology> findByProg_Id(int id);

	@Query("FROM Technology WHERE prog_id=?1 AND techno=?2")
	Technology findByProgAndTech(int id, String techno);
	
//	@Transactional
//	@Modifying
//	@Query("UPDATE Technology SET techno=?2, exp=?3, specialization=?4 WHERE tId=?1")
//	void updateById(int id, String tech, int exp, String spclztn);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Technology WHERE prog_id=?1")
	void deleteByProg_id(int id);

	@Transactional
	@Modifying
	@Query("DELETE FROM Technology WHERE prog_id=?1 AND techno=?2")
	void deleteByTechAndProg_id(int id, String techno);
}
