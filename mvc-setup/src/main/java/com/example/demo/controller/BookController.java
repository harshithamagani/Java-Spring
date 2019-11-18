package com.example.demo.controller;

import com.example.demo.models.*;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.services.BookService;

@Controller
public class BookController {

	public final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService=bookService;
	}
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
	
	@RequestMapping("/books/new")
	public String createForm(@ModelAttribute("book") Book book) {
		return "/books/new.jsp";
	}
	
	@RequestMapping("/books/create")
	public String postBook(@Valid @ModelAttribute("book")Book book ,BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Errorr");
			return "/books/new.jsp";
		}
		else {
			System.out.println("Save book");
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	@RequestMapping("/books/{id}")
	public String showBook(@PathVariable("id")Long id,Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "/books/show.jsp";
	}
	
	 @RequestMapping("/books/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Book book = bookService.findBook(id);
	        model.addAttribute("book", book);
	        return "/books/edit.jsp";
	    }
	    
	    @RequestMapping(value="/books/{id}", method=RequestMethod.POST)
	    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/books/edit.jsp";
	        } else {
	            bookService.updateBook(book );
	            return "redirect:/books";
	        }
	    }
	    
	    @RequestMapping(value="/books/{id}" , method=RequestMethod.DELETE)
	    public String delete(@PathVariable("id") Long id) {
	    	bookService.deleteBook(id);
	    	return "redirect:/books";
	    }
}
