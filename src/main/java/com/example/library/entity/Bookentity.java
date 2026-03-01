package com.example.library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Bookentity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bookId;
	@Column(length=1000)
	private String booktitle;
	@Column(length=1000)
	private String author;
	@Column(length=1000)
	private boolean issuedstatus=false;
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Bookentity() {
		
	}
	
	public boolean isIssuedstatus() {
		return issuedstatus;
	}
	public void setIssuedstatus(boolean issuedstatus) {
		this.issuedstatus = issuedstatus;
	}
	public Studententity getBorrowedBy() {
		return borrowedBy;
	}
	public void setBorrowedBy(Studententity borrowedBy) {
		this.borrowedBy = borrowedBy;
	}
	public Bookentity(Long bookId, String booktitle, String author, boolean issuedstatus, Studententity borrowedBy) {
		super();
		this.bookId = bookId;
		this.booktitle = booktitle;
		this.author = author;
		this.issuedstatus=false;
		this.borrowedBy = borrowedBy;
	}
	
	@ManyToOne
	@JoinColumn(name="borrowed_by_id")
	private Studententity borrowedBy;
}
