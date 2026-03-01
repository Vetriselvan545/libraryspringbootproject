package com.example.library.bookRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.Studententity;

public interface Studentrepository extends JpaRepository <Studententity,Long>{

}
