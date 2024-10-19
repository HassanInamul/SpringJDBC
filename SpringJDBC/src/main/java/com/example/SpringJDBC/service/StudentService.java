package com.example.SpringJDBC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringJDBC.model.Student;
import com.example.SpringJDBC.repo.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository repo;

	public StudentRepository getRepo() {
		return repo;
	}
	@Autowired
	public void setRepo(StudentRepository repo) {
		this.repo = repo;
	}
	public void addStudent(Student st) {
		repo.save(st);
	}
	public List<Student> getAllStudents() {
		return repo.findAll();
	}
	

}
