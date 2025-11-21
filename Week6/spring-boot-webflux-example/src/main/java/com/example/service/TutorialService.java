package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Tutorial;
import com.example.repository.TutorialRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TutorialService {

  @Autowired
  TutorialRepository tutorialRepository;

  public Flux<Tutorial> findAll() {
    return tutorialRepository.findAll();
  }

  public Flux<Tutorial> findByTitleContaining(String title) {
    return tutorialRepository.findByTitleContaining(title);
  }

  public Mono<Tutorial> findById(int id) {
    return tutorialRepository.findById(id);
  }

  public Mono<Integer> save(Tutorial tutorial) {
    Mono<Tutorial> savedTutorial= tutorialRepository.save(tutorial);
    return savedTutorial.map(Tutorial::getId);
    
    
  }

  public Mono<Tutorial> update(int id, Tutorial tutorial) {
    return tutorialRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
        .flatMap(optionalTutorial -> {
          if (optionalTutorial.isPresent()) {
            tutorial.setId(id);
            return tutorialRepository.save(tutorial);
          }

          return Mono.empty();
        });
  }
//map = synchronous transform
//  map gives <Mono<Mono<Tutorial>>
//  flat map gives <Mono<Tutorial>>
//flatMap = asynchronous transform
		  

  public Mono<Void> deleteById(int id) {
    return tutorialRepository.deleteById(id);
  }

  public Mono<Void> deleteAll() {
    return tutorialRepository.deleteAll();
  }

  public Flux<Tutorial> findByPublished(boolean isPublished) {
    return tutorialRepository.findByPublished(isPublished);
  }
}
