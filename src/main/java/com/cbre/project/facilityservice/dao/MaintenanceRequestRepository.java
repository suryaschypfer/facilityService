package com.cbre.project.facilityservice.dao;

import com.cbre.project.facilityservice.entity.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRequestRepository extends JpaRepository<MaintenanceRequest, Long> {
}
