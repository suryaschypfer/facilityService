package com.cbre.project.facilityservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "maintenance_requests")
public class MaintenanceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String status = "OPEN"; // Default thing we will put
    private LocalDateTime createdAt = LocalDateTime.now();

	@ManyToOne
	@JoinColumn(name = "property_id")
	private Property property; 

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public int hashCode() {
		return Objects.hash(createdAt, description, id, property, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaintenanceRequest other = (MaintenanceRequest) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(property, other.property)
				&& Objects.equals(status, other.status);
	}
	@Override
	public String toString() {
		return "MaintenanceRequest [id=" + id +  ", description=" + description
				+ ", status=" + status + ", createdAt=" + createdAt + ", property=" + property + "]";
	}
	public MaintenanceRequest(Long id, Long propertyId, String description, String status, LocalDateTime createdAt,
			Property property) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
		this.property = property;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	public MaintenanceRequest() {
		// TODO Auto-generated constructor stub
	}
	
    
}