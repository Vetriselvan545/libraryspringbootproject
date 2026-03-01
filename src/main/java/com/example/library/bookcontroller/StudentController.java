package com.example.library.bookcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.bookRepository.Studentrepository;
import com.example.library.entity.Studententity;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private Studentrepository studentrepository;
@PostMapping("/addstudent")
public Studententity save(@RequestBody Studententity student) {
	return studentrepository.save(student);
}
}
