package com.cbre.project.facilityservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbre.project.facilityservice.entity.Property;
import com.cbre.project.facilityservice.entity.User;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    Property findById(long id);
    List<Property> findByOwner(User owner);
}