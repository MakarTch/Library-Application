package com.cognixia.application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.application.model.OnHold;

@Repository
public interface OnHoldDAO extends JpaRepository<OnHold, Integer> {
	public OnHold findByTransactionId(int transactionId);
	public List <OnHold> findAllByUserId(int userId);
}
