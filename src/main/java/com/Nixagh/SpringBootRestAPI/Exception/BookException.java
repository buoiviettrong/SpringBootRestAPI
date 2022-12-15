package com.Nixagh.SpringBootRestAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.Nixagh.SpringBootRestAPI.models.Book;

public class BookException {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public static Book BookNotFoundException(String id) {
		return null;
	}
}
