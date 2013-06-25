package org.ikane.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="VEHICLE_TYPE", discriminatorType=DiscriminatorType.STRING)
public class Vehicle {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int vehicleId;
	private String vehicleName;
	
//	@ManyToOne
//	@JoinColumn(name="USER_ID")
//	UserDetails user;
	
	@ManyToMany(mappedBy="vehicles")
	Collection<UserDetails> users = new ArrayList<UserDetails>();
	

	public Collection<UserDetails> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserDetails> users) {
		this.users = users;
	}

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
