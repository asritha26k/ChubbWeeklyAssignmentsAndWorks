package com.example.MongoSpring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//we annotate this class for mongo db we use document
@Document//document means like a table
@Data //lombok  - for getters setters
@NoArgsConstructor
@AllArgsConstructor
public class Student {
//in student class we have key value pairs only in mongo db
	@Id
	private Integer rno;
	private String name;
	private String address;
}

