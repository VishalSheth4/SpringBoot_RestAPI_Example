package com.restAPI.test.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restAPI.test.controller.entities.Book;
import com.restAPI.test.services.BookServices;

@RestController
public class BookController {
		
	@Autowired
	private BookServices bookservices;
	
	
	@GetMapping("/books")
	public List<Book> getBook() {
		return this.bookservices.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return this.bookservices.getBookById(id);
	}

//	@RequestMapping(value="/books", method = RequestMethod.GET)
//	public Book getBooks() {
//		Book book = new Book();
//		book.setId(12345);
//		book.setTitle("Java REST API");
//		book.setAuthor("Vishal");
//		return book;
////		return "this is testing book first";
//	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b = this.bookservices.addBook(book);
		System.out.println(book.toString());
		return b;
	}
	
	@DeleteMapping("/books/{bookId}")
	public Book deleteBook(@PathVariable("bookId") int bookId) {
		Book b = new Book();
		this.bookservices.deleteBook(bookId);
		return b;
	}
	
	// Update Book Handler
	@PutMapping("/books/{bookId}")
	public void updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		this.bookservices.updateBook(book,bookId);
//		return book;
	}
	

}
