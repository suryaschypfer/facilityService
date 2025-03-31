package com.cbre.project.facilityservice.dto;

import java.util.Objects;

public class MaintenanceEvent {
    private Long propertyId;
    private String managerEmail;
    private String requestDescription;
	public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	public String getRequestDescription() {
		return requestDescription;
	}
	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}
	@Override
	public int hashCode() {
		return Objects.hash(managerEmail, propertyId, requestDescription);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaintenanceEvent other = (MaintenanceEvent) obj;
		return Objects.equals(managerEmail, other.managerEmail) && Objects.equals(propertyId, other.propertyId)
				&& Objects.equals(requestDescription, other.requestDescription);
	}
	@Override
	public String toString() {
		return "MaintenanceEvent [propertyId=" + propertyId + ", managerEmail=" + managerEmail + ", requestDescription="
				+ requestDescription + "]";
	}
	public MaintenanceEvent(Long propertyId, String managerEmail, String requestDescription) {
		super();
		this.propertyId = propertyId;
		this.managerEmail = managerEmail;
		this.requestDescription = requestDescription;
	}

    
}