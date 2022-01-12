package com.restAPI.test.services;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.restAPI.test.controller.entities.Book;

@Component
public class BookServices {
	static private List<Book> list = new ArrayList<>();
	static {
		list.add(new Book(12,"JAVA","XYZ"));
		list.add(new Book(123,"PYTHON","PQRS"));
		list.add(new Book(454,"RUBY","DEFG"));
	}
	
	public List<Book> getAllBooks(){
		return list;
	}
	
	public Book getBookById(int Id) {
		Book book = list.stream().filter(e->e.getId()==Id).findFirst().get();
		return book;		
	}
	
	public Book addBook(Book book) {
		list.add(book);
		return book;
	}
	
	public void deleteBook(int bookId) {
		list = list.stream().filter(book -> {
			if(book.getId()!=bookId) {
				return true;
			}else {
				return false;
			}
		}).collect(Collectors.toList());
	}
	
	public void updateBook(Book book, int bookId) {
		// TODO Auto-generated method stub
		list = list.stream().filter(b->{
			if(b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
				return true;
			}else {
				return false;
			}
		}).collect(Collectors.toList());
		
	}
}
