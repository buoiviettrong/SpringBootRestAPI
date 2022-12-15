package com.Nixagh.SpringBootRestAPI.Api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Nixagh.SpringBootRestAPI.Services.BookService;
import com.Nixagh.SpringBootRestAPI.Specifications.BookQuery;
import com.Nixagh.SpringBootRestAPI.models.Book;

@RestController()
@RequestMapping("/api/v1/books")
@CrossOrigin
public class BookApi {

	@Autowired
	BookService bookService;
	@Autowired
	BookQuery bookQuery;
	@Autowired
	MongoTemplate mongoTemplate;
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {
		return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") String id) {
		Book book = bookService.getOne(id);
		if(book != null)
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		else 
			return new ResponseEntity<Book>(book, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/search")
	public Page<Book> getBookWithFilter(
			@RequestParam(name = "masach", required = false) String masach,
			@RequestParam(name = "tensach", required = false) String tensach,
			@RequestParam(name = "soluong", required = false, defaultValue = "0") int soluong,
			@RequestParam(name = "gia", required = false, defaultValue = "0") int gia,
			@RequestParam(name = "maloai", required = false) String maloai,
			@RequestParam(name = "tacgia", required = false) String tacgia,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
		
		Pageable paging = PageRequest.of(page, size);
		Query query = bookQuery.getQuery(masach, tensach, soluong, gia, maloai, tacgia);
		long count = mongoTemplate.count(query, Book.class);
		List<Book> books = mongoTemplate.find(query.with(paging), Book.class);
		
		return PageableExecutionUtils.getPage(books, paging, () -> count);
	}
	
	@GetMapping("/search/body")
	public Page<Book> getBookWithFilter(
			@RequestBody Book book,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
		
		Pageable paging = PageRequest.of(page, size);
		Query query = bookQuery.getQuery(book.getMasach(), book.getTensach(), book.getSoluong(), book.getGia(), book.getMaloai(), book.getTacgia());
		long count = mongoTemplate.count(query, Book.class);
		List<Book> books = mongoTemplate.find(query.with(paging), Book.class);
		
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.entrySet("data", books);
		
		return PageableExecutionUtils.getPage(books, paging, () -> count);
	}
	
}
