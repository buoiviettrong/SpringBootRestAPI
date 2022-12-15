package com.Nixagh.SpringBootRestAPI.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.Nixagh.SpringBootRestAPI.Exception.BookException;
import com.Nixagh.SpringBootRestAPI.Repositories.BookRepository;
import com.Nixagh.SpringBootRestAPI.models.Book;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;

	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	public Book getOne(String id) {
		return bookRepository.findById(id).orElse(null);
	}

	public Page<Book> find(String masach, String tensach, int soluong, int gia, String maloai, String tacgia,
			Pageable paging) {
		return bookRepository.find(masach, tensach, soluong, gia, maloai, tacgia, paging);
	}

	public Page<Book> findByExample(Book book, Pageable paging) {
		Example<Book> emp = Example.of(book);
		return bookRepository.findAll(emp, paging);
	}

//	public Page<Book> getByFilter(Query query, Pageable paging) {
//		return bookRepository.findByFilter(query, paging);
//	}

}
