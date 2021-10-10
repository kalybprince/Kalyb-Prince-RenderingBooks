package com.kalyb.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kalyb.mvc.models.Book;
import com.kalyb.mvc.repos.BookRepo;

@Service
public class BookService {
	private final BookRepo bookRepo;
	
	public BookService(BookRepo bRepo) {
		this.bookRepo = bRepo;
	}
	
	public List<Book> getAll(){
		return bookRepo.findAll();
	}
	
	public Book getOne(Long id){
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book newBook = getOne(id);
		newBook.setTitle(title);
		newBook.setDescription(desc);
		newBook.setLanguage(lang);
		newBook.setNumberOfPages(numOfPages);
		return bookRepo.save(newBook);
	}
	
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
