package com.example.demo.controller;

import com.example.demo.models.Book;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.BookService;

@RestController
public class BookApi {
	
	private final BookService bookService;
	
	public BookApi(BookService bookService) {
		this.bookService=bookService;
	}
	
	@RequestMapping("/api/books")
	public List<Book> getBooks(){
		return bookService.allBooks();
	}
	
	@RequestMapping("/api/books/{id}")
	public Book getBook(@PathVariable("id")Long id) {
		return bookService.findBook(id);	
	}
	
	@RequestMapping(value="/api/books",method=RequestMethod.POST)
	public Book createBook(@RequestParam(value="title")String title,@RequestParam(value="description")String description,@RequestParam(value="language")String language,@RequestParam(value="numberOfPages")Integer numberOfPages) {
		return bookService.createBook(new Book(title,description,language,numberOfPages));
	}
	
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }
	
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }

}
