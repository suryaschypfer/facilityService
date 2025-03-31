package com.cbre.project.facilityservice.service;

import com.cbre.project.facilityservice.dao.MaintenanceRequestRepository;
import com.cbre.project.facilityservice.dto.MaintenanceEvent;
import com.cbre.project.facilityservice.entity.MaintenanceRequest;
import com.cbre.project.facilityservice.entity.Property;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MaintenanceRequestService {

    private final MaintenanceRequestRepository requestRepo;
    private final PropertyService propertyService;
    private final KafkaTemplate<String, MaintenanceEvent> kafkaTemplate;

    public MaintenanceRequestService(
        MaintenanceRequestRepository requestRepo,
        PropertyService propertyService,
        KafkaTemplate<String, MaintenanceEvent> kafkaTemplate
    ) {
        this.requestRepo = requestRepo;
        this.propertyService = propertyService;
        this.kafkaTemplate = kafkaTemplate;
    }

    public MaintenanceRequest createMaintenanceRequest(Long propertyId, String description) {
        // Fetch complete property entity
        Property property = propertyService.getPropertyById(propertyId);
        
        // Create and save request
        MaintenanceRequest request = new MaintenanceRequest();
        request.setProperty(property);
        request.setDescription(description);
        request.setStatus("OPEN");
        MaintenanceRequest savedRequest = requestRepo.save(request);
        
        // Get email through JPA relationship
        String managerEmail = property.getOwner().getEmail();
        
        // Send event
        kafkaTemplate.send("maintenance-topic", 
            new MaintenanceEvent(propertyId, managerEmail, description));
        
        return savedRequest;
    }
}