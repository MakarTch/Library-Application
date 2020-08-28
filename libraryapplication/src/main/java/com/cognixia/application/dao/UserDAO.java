package com.cognixia.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognixia.application.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

	public User findByUserIdAndUserPassword(int userId, String userPassword);
	public boolean existsByUserIdAndUserPassword(int userId, String userPassword);
	public User findByUserId(int userId);
}
