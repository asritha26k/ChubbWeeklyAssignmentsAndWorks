package com.example.tutorial_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutorial_service.model.Tutorial;
import com.example.tutorial_service.service.TutorialService;

@RestController
public class TutorialController {

	@Autowired
	private TutorialService service;

	@GetMapping("/{id}")
	public Tutorial getById(@PathVariable Long id) {
		return service.getTutorial(id);
	}

	@GetMapping
	public List<Tutorial> getAll() {
		return service.getAllTutorials();
	}

	@PostMapping
	public Tutorial create(@RequestBody Tutorial t) {
		return service.createTutorial(t);
	}

	@PutMapping("/{id}")
	public Tutorial update(@PathVariable Long id, @RequestBody Tutorial t) {
		return service.updateTutorial(id, t);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		service.deleteTutorial(id);
		return "Deleted";
	}

}
