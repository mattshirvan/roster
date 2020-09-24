package com.matt.roster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.matt.roster.models.Contact;
import com.matt.roster.models.Student;
import com.matt.roster.services.RosterService;

@Controller
public class RosterController {
	private final RosterService rosterService;
	
	public RosterController(RosterService rosterService) {
		this.rosterService = rosterService;
	}
	
	@RequestMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student student) {
		return "New";
	}
	
	@RequestMapping(value = "/students/create", method = RequestMethod.POST)
	public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "New";
		}
		
		else {
			rosterService.createStudent(student);
			return "redirect:/contact/new";
		}
	}
	
	@RequestMapping("/contact/new")
	public String newContact(@ModelAttribute("contact") Contact contact, @ModelAttribute("student") Student student, Model model) {
		List<Student> students = rosterService.getStudents();
		model.addAttribute("students", students);
		return "NewAdd";
	}
	
	@RequestMapping(value = "/contact/create", method = RequestMethod.POST)
	public String createContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {
		if (result.hasErrors()) {
			return "NewAdd";
		}
		
		else {
			rosterService.createContact(contact);
			return "redirect:/students";
		}
	}
	
	@RequestMapping("/students")
	public String index(Model model) {
		List<Student> students = rosterService.getStudents();
		model.addAttribute("students", students);
		return "Index";
	}
}
