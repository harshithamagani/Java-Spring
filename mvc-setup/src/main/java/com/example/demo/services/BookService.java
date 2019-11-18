package com.example.demo.services;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;
import com.example.demo.models.Book;

import com.example.demo.repositories.BookRepository;

@Service
public class BookService {
	
	private BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	public Book createBook(Book b){
		return bookRepo.save(b);
	}
	
	public Book findBook(Long id) {
		Optional<Book> opBook = bookRepo.findById(id);
		if(opBook.isPresent()) {
			return opBook.get();
		}
		else {
			return null;
		}
	}

	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Optional<Book> opBook = bookRepo.findById(id);
		if(opBook.isPresent()) {
			Book updateBook = opBook.get();
			updateBook.setTitle(title);
			updateBook.setDescription(desc);
			updateBook.setLanguage(lang);
			updateBook.setNumberOfPages(numOfPages);
			return bookRepo.save(updateBook);
		}
		else {
			return null;
		}
	}

	public void deleteBook(Long id) {
		bookRepo.deleteById(id);		
	}

	public Book updateBook(Book book) {
		Optional<Book> opBook = bookRepo.findById(book.getId());
		if(opBook.isPresent()) {
			return  bookRepo.save(book);
		}
		else {
			return null;
		}
	}
	

}
