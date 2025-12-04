package com.example.MongoSpring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.MongoSpring.model.Student;

public interface StudentRepo extends MongoRepository<Student,Integer>{
//this mongo repository takes 2 parameters
	// we have to link it! we link by puting student document
	//and also other parameter is data type of the primary key of the document
	
	//fetching all students
	
}
