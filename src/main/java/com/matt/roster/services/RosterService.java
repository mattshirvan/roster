package com.matt.roster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matt.roster.models.Contact;
import com.matt.roster.models.Student;
import com.matt.roster.repositories.ContactRepository;
import com.matt.roster.repositories.StudentRepository;

@Service
public class RosterService {
	private final StudentRepository studentRepository;
	private final ContactRepository contactRepository;
	
	public RosterService(StudentRepository studentRepository, ContactRepository contactRepository) {
		this.studentRepository = studentRepository;
		this.contactRepository = contactRepository;
	}
	
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	
	public Student getStudent(Long id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Contact createContact(Contact contact) {
		return contactRepository.save(contact);
	}
	
	public Contact updateContact(Contact contact) {
		return contactRepository.save(contact);
	}
	
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}
