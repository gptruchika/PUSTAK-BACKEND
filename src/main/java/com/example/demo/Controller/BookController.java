package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/book")
	public void addBook(@RequestBody Book book) {
		bookRepository.save(book);
	}
	
	@PostMapping("/addBooks")
	public void addListOfBook(@RequestBody List<Book> books) {
		bookRepository.saveAll(books);
	}
	
	@GetMapping("/{category}")
	public List<Book> getBooksByCategoryBooks (@PathVariable("category")String category){
		return bookRepository.findAllByCategory(category);
	}
	
	@GetMapping("/book/{id}")
	public Book getBooksByGenre(@PathVariable("id")int id) {
		Book bookDetail = this.bookRepository.findById((long) id).get();
		return bookDetail;
	}
	
	@GetMapping("/selected")
	public List<Book> getBooksForHomeBooks(){
		return bookRepository.findAll(PageRequest.of(0, 3)).getContent();
	}
	
}
