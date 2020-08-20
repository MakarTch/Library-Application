package com.cognixia.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.application.model.OnHold;

@Repository
public interface OnHoldDAO extends JpaRepository<OnHold, Integer> {
	public OnHold findByTransactionId(int transactionId);
}
