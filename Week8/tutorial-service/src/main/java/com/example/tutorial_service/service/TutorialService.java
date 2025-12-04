package com.example.tutorial_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.tutorial_service.model.Tutorial;
import com.example.tutorial_service.repository.TutorialRepository;

@Service
public class TutorialService {
	@Autowired
	private TutorialRepository repo;

	// caching individual tutorial
	@Cacheable(value = "tutorial", key = "#id")
	public Tutorial getTutorial(Long id) {
		System.out.println("Fetching from db..");
		return repo.findById(id).orElse(null);
	}

	// caching list of students
	@Cacheable(value = "tutorialList")
	public List<Tutorial> getAllTutorials() {
		System.out.println("Fetching list from db..");
		return repo.findAll();
	}

	@CacheEvict(value = { "tutorial", "tutorialList" }, allEntries = true)
	public Tutorial createTutorial(Tutorial t) {
		return repo.save(t);
	}

	@CachePut(value = "tutorial", key = "#id")
	@CacheEvict(value = "tutorialList", allEntries = true)
	public Tutorial updateTutorial(Long id, Tutorial updated) {
		updated.setId(id);
		return repo.save(updated);
	}

	@CacheEvict(value = { "tutorial", "tutorialList" }, allEntries = true)
	public void deleteTutorial(Long id) {
		repo.deleteById(id);
	}
}
