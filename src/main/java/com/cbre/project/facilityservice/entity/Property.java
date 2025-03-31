package com.cbre.project.facilityservice.entity;

import java.util.Objects;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String status;
    private String location;
    private double price;
//    @Column(name = "owner")
    @ManyToOne
    @JoinColumn(name = "owner_id")  //dbcolumn match
    private User owner;  
    
    public Property() {
    }

	public Property(Long id, String name, String status, String location, double price, User owner) {
	super();
	this.id = id;
	this.name = name;
	this.status = status;
	this.location = location;
	this.price = price;
	this.owner = owner;
}
	@Override
	public String toString() {
		return "Property [id=" + id + ", name=" + name + ", status=" + status + ", location=" + location + ", price="
				+ price + ", owner=" + owner + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, location, name, owner, price, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		return Objects.equals(id, other.id) && Objects.equals(location, other.location)
				&& Objects.equals(name, other.name) && Objects.equals(owner, other.owner)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(status, other.status);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public User getOwner() { 
		return owner; 
	}
    public void setOwner(User owner) { 
    	this.owner = owner; 
    }
}