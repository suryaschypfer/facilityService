package com.cbre.project.facilityservice.contorller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cbre.project.facilityservice.entity.MaintenanceRequest;
import com.cbre.project.facilityservice.entity.Property;
import com.cbre.project.facilityservice.service.MaintenanceRequestService;
import com.cbre.project.facilityservice.service.PropertyService;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceController {
    
    private final MaintenanceRequestService requestService;
    private final PropertyService propertyService;

    public MaintenanceController(MaintenanceRequestService requestService, PropertyService propertyService) {
        this.requestService = requestService;
		this.propertyService = propertyService;
    }
    
    @GetMapping("/property")
    public Property getProperty(@RequestParam Long propertyId) {
        return propertyService.getPropertyById(propertyId);
    }
    
    @GetMapping("/email")
    public String getManageremail(@RequestParam Long propertyId) {
        return propertyService.getManagerEmail(propertyId);
    }
    
    @PostMapping
    public MaintenanceRequest createRequest( @RequestParam Long propertyId, @RequestParam String description) {
        return requestService.createMaintenanceRequest(propertyId, description);
    }
}