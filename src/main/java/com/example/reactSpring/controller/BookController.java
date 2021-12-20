package com.example.reactSpring.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.reactSpring.model.Books;
import com.example.reactSpring.model.Student;
import com.example.reactSpring.repository.BookRepository;
import com.example.reactSpring.repository.StudentRepository;

@CrossOrigin(origins = "*")
@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private StudentRepository studentRepository;

	// Request: GET /ping, Response: "Up-books"
	@GetMapping("/test")
	public String ping() {
		return "Working";
	}

	// Request: GET /books, Response: Book[]
	@GetMapping("/books")
	public List<Books> getAllBooks() {
		return bookRepository.findAll();
	}

	// Request: GET /book/{id}, Response: Book
	@GetMapping("/book/{id}")
	public Optional<Books> getBookById(@PathVariable int id) {
		return bookRepository.findById(id);
	}

	// Request: POST /book, Response: Book
	@PostMapping("/book")
	public Books saveBook(@RequestBody Books books) {
		return bookRepository.save(books);
	}

	// Request: DELETE /book/{id}, Response: void
	@DeleteMapping("/book/{id}")
	public void deleteBookById(@PathVariable int id) {
		bookRepository.deleteById(id);
	}

	// Request: PUT /book/{id}, Response: Book
	@PutMapping("/book/{id}")
	Books updateBookById(@RequestBody Books newBook, @PathVariable int id) {
		return bookRepository.findById(id).map(book -> {
			book.setName(newBook.getName());
			book.setAuthor(newBook.getAuthor());
			book.setPrice(newBook.getPrice());
			book.setEdition(newBook.getEdition());
			book.setCustomer(newBook.getCustomer());
			return bookRepository.save(book);
		}).orElseGet(() -> {
			newBook.setId(id);
			return bookRepository.save(newBook);
		});
	}

	// Request: POST /register, Response: Student
	@PostMapping("/register")
	public Student registerDetails(@RequestBody Student student) {
		return studentRepository.save(student);
	}


}
