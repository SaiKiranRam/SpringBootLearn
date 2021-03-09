package edu.user.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.user.learning.entity.Programmer;

public interface ProgrammerRepository extends JpaRepository<Programmer, Long> {

}
