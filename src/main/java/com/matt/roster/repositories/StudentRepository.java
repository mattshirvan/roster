package com.matt.roster.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.matt.roster.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	List<Student> findAll();
	
	@Query(value = "SELECT s.* students s LEFT OUTER JOIN contacts c on s.id = c.student_id WHERE c.id IS NULL", nativeQuery = true)
	List<Student> findByContact();
}
