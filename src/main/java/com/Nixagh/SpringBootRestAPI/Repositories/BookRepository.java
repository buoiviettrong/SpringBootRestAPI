package com.Nixagh.SpringBootRestAPI.Repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Nixagh.SpringBootRestAPI.models.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String>{

	@Query("{ masach: masach, tensach: tensach, soluong: soluong, gia: gia, maloai: maloai, tacgia: tacgia }")
	Page<Book> find(
			@Param("masach") String masach,
			@Param("tensach") String tensach,
			@Param("soluong") int soluong,
			@Param("gia") int gia,
			@Param("maloai") String maloai,
			@Param("tacgia") String tacgia,
			Pageable paging);
}
