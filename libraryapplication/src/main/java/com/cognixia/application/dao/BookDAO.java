package com.cognixia.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognixia.application.model.Book;

@Repository
public interface BookDAO extends JpaRepository<Book, Long>{
	
	public Book findByBookISBN(long isbn);

}
