package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Tutorial;
import com.example.demo.service.TutorialService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TutorialController {

  @Autowired
  TutorialService tutorialService;

  @GetMapping("/tutorials")
  @ResponseStatus(HttpStatus.OK)
  public Flux<Tutorial> getAllTutorials(@RequestParam(required = false) String title) {
    if (title == null)
      return tutorialService.findAll();
    else
      return tutorialService.findByTitleContaining(title);
  }

  @GetMapping("/tutorials/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Tutorial> getTutorialById(@PathVariable("id") String id) {
    return tutorialService.findById(id);
  }

  @PostMapping("/tutorials")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
//	  Tutorial newTutorial = Tutorial.builder()
//			    .id(tutorial.getId())
//			    .title(tutorial.getTitle())
//			    .description(tutorial.getDescription())
//			    .published(tutorial.isPublished())
//			    .build();

	  return tutorialService.save(tutorial);
  }

  @PutMapping("/tutorials/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Tutorial> updateTutorial(@PathVariable("id") String id, @RequestBody Tutorial tutorial) {
    return tutorialService.update(id, tutorial);
  }

  @DeleteMapping("/tutorials/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteTutorial(@PathVariable("id") String id) {
    return tutorialService.deleteById(id);
  }

  @DeleteMapping("/tutorials")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteAllTutorials() {
    return tutorialService.deleteAll();
  }

  @GetMapping("/tutorials/published")
  @ResponseStatus(HttpStatus.OK)
  public Flux<Tutorial> findByPublished() {
    return tutorialService.findByPublished(true);
  }
}
