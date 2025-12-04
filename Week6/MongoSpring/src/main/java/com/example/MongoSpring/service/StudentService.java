package com.example.MongoSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.MongoSpring.model.Student;
import com.example.MongoSpring.repository.StudentRepo;
@Service
public class StudentService {
	@Autowired
	StudentRepo studentRepo;
	
	
	public void addStudentService(Student student) {
		//to save that particular data we use repository
		studentRepo.save(student);
		//we also need to add configuration to link our project
		
		
	}
	//now lets fetch the data
	public List<Student> fetchStudentService(){
		return studentRepo.findAll();
	}
	
	//getting one studentby id
	public Student getStudentService(Integer id) {
		return studentRepo.findById(id).orElse(null);
		//just findById gives optional so if we use orelse null
		//then it unwraps optional to student !
	}
	//if we want to update any details of the students!!
	public void updateStudentService(Student student) {
		//first we fetch the object
		//modify it and save it back
		
		Student data = studentRepo.findById(student.getRno()).orElse(null);
		if(data!=null) {
			data.setName(student.getName());
			data.setAddress(student.getAddress());
			studentRepo.save(data);
		}
		
	}
	public void deleteStudentService(Integer id) {
		studentRepo.deleteById(id);
	}
}
