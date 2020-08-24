package com.cognixia.application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognixia.application.model.Borrowed;

@Repository
public interface BorrowedDAO extends JpaRepository<Borrowed, Integer>{
	public Borrowed findByTransactionId(int transacationId);
	public List<Borrowed> findAllByUserId(int userId);
}
