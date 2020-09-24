package com.matt.roster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.matt.roster.models.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	List<Contact> findAll();
	
	Contact findByStudentId(Long id);
}
