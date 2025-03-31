package com.cbre.project.facilityservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbre.project.facilityservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByName(String name);
}
