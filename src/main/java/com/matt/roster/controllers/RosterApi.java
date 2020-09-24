package com.matt.roster.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matt.roster.models.Contact;
import com.matt.roster.models.Student;
import com.matt.roster.services.RosterService;

@RestController
public class RosterApi {
	private final RosterService rosterService;
	
	public RosterApi(RosterService rosterService) {
		this.rosterService = rosterService;
	}
	
	@GetMapping("api/students")
	public List<Student> index() {
		return rosterService.getStudents();
	}
	
	@PostMapping("api/students")
	public Student createStudent(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("age") int age ) {
		Student student = new Student(firstName, lastName, age);
		return rosterService.createStudent(student);
	}
	
	@GetMapping("api/students/{id}")
	public Student getStudent(@PathVariable("id") Long id) {
		Student student = rosterService.getStudent(id);
		return student;
	}
	
	@PutMapping("api/students/{id}")
	public Student updateStudent(@PathVariable("id") Long id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("age") int age) {
		Student student = rosterService.getStudent(id);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setAge(age);
		return rosterService.updateStudent(student);
	}
	
	@DeleteMapping("/api/students/{id}")
	public void deleteStudent(@PathVariable("id") Long id) {
		rosterService.deleteStudent(id);
	}
	
	@PostMapping("/api/contact")
	public Contact addContact(@RequestParam("address") String address, @RequestParam("city") String city, @RequestParam("state") String state, @RequestParam("id") Long id) {
		Student student = rosterService.getStudent(id);
		Contact contact = new Contact(address, city, state, student);
		return rosterService.createContact(contact);
		
	}
	
}
