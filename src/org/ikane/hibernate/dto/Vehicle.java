package org.ikane.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int vehicleId;
	private String vehicleName;
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	
	public Vehicle(int vehicleId, String vehicleName) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
	}

	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
}
