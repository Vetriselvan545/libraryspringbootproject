package com.example.library.bookservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.bookRepository.BookRepository;
import com.example.library.bookRepository.Studentrepository;
import com.example.library.entity.Bookentity;
import com.example.library.entity.Studententity;

@Service
public class BookService {
	@Autowired
	private BookRepository bookrepository;
	@Autowired
	private Studentrepository studentrepository;
	public Bookentity savesbookentity(Bookentity bookentity) {
		return bookrepository.save(bookentity);
	}
	public List<Bookentity> getbooks(){
		return bookrepository.findAll();
	}
	public String issuedbook(Long bookId,Long id){
		Bookentity book=bookrepository.findById(bookId).orElse(null);
		if(book==null) {
			return "Book is not found";
		}
		if(book.getBorrowedBy()!=null){
			return "Book is already issued";
			
		}
		Studententity student = studentrepository.findById(id).orElse(null);
		if(student==null) {
			return "student not found";
		}
		book.setBorrowedBy(student);
		book.setIssuedstatus(true);
		bookrepository.save(book);
		return "issuedStudent name is"+student.getName();
	}
	public String returnbook(Long bookId) {
		Bookentity book=bookrepository.findById(bookId).orElse(null);
		if(book==null) {
			return "book is not found";
		}
		if(book.getBorrowedBy()==null) {
			return "book is not issued";
		}
		book.setBorrowedBy(null);
		book.setIssuedstatus(false);
		bookrepository.save(book);
		return "book is returned";
		
	}
}
