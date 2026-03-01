package com.example.library.bookcontroller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.bookservice.BookService;
import com.example.library.entity.Bookentity;

@RestController
public class BookController {
@Autowired
private BookService bookservice;
@PostMapping("bookadd")
public Bookentity createBookentity (@RequestBody Bookentity bookentity) {
 return bookservice.savesbookentity(bookentity);
}
@GetMapping("bookview")
public List<Bookentity> getbooks(){
	return bookservice.getbooks();
}
@GetMapping("Available/{bookId}/issue/{id}")
public String issuedbook(@PathVariable Long bookId,@PathVariable Long id){
 return bookservice.issuedbook(bookId,id);
}
@PostMapping("Return/{bookId}")
public String returnbook(@PathVariable Long bookId) {
	return bookservice.returnbook(bookId);
}
}