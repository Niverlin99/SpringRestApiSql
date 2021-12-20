package com.example.reactSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.reactSpring.model.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {

}
