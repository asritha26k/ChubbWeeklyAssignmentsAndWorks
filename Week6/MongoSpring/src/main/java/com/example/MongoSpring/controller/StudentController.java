package com.example.MongoSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MongoSpring.model.Student;
import com.example.MongoSpring.repository.StudentRepo;
import com.example.MongoSpring.service.StudentService;

//we annotate to define that we are going to have uri
@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	
	
	@PostMapping("/addStudent")//means we are posting data
	public void addStudent(@RequestBody Student student) {
		studentService.addStudentService(student);
		
		
	}
	//now lets fetch the data
	@GetMapping("/fetchStudents")
	public List<Student> fetchStudent(){
		return studentService.fetchStudentService();
	}
	
	//getting one studentby id
	@GetMapping("getStudent/{id}")
	public Student getStudent(@PathVariable Integer id) {
		return studentService.getStudentService(id);
	}
	//if we want to update any details of the students!!
	@PutMapping("/updateStudent")
	public void updateStudent(@RequestBody Student student) {
		
		studentService.updateStudentService(student);
		
	}
	@DeleteMapping("deleteStudent/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		studentService.deleteStudentService(id);
	}

}
