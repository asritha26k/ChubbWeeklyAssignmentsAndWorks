package com.example.tutorial_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tutorial_service.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}
