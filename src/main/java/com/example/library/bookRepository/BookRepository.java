package com.example.library.bookRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.Bookentity;

public interface BookRepository extends JpaRepository<Bookentity,Long> {
List <Bookentity>findByBorrowedByIsNull();

 
}
