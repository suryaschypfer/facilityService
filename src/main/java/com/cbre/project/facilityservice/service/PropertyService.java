package com.cbre.project.facilityservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cbre.project.facilityservice.dao.PropertyRepository;
import com.cbre.project.facilityservice.dao.UserRepository;
import com.cbre.project.facilityservice.entity.Property;
import com.cbre.project.facilityservice.entity.User;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepo;
    private final UserRepository userRepo;

    public PropertyService(PropertyRepository propertyRepo, UserRepository userRepo) {
        this.propertyRepo = propertyRepo;
        this.userRepo = userRepo;
    }
    
    public Property getPropertyById(Long propertyId) {
        return propertyRepo.findById(propertyId)
            .orElseThrow(() -> new RuntimeException("Property not found!"));
    }


    public String getManagerEmail(Long propertyId) {
        Property property = propertyRepo.findById(propertyId)
            .orElseThrow(() -> new RuntimeException("Property not found"));
        
        return Optional.ofNullable(property.getOwner())
            .map(User::getEmail)
            .orElse("Manager not found");
    }
}
