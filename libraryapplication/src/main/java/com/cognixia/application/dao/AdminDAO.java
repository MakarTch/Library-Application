package com.cognixia.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognixia.application.model.Admin;

@Repository
public interface AdminDAO extends JpaRepository<Admin, Integer> {
	public boolean existsByAdminIdAndAdminPassword(int adminId, String adminPassword);
}
