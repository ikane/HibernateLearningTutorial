package org.ikane.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Column;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@Basic
	private String username;
	@Temporal(TemporalType.DATE)
	private Date joinDate;
	@Lob
	private String description;
	
	@Embedded
	private Address homeAddress;
	
	@Embedded
	
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="JOB_STREET_NAME")),
		@AttributeOverride(name="city", column=@Column(name="JOB_CITY_NAME")),
		@AttributeOverride(name="state", column=@Column(name="JOB_STATE_NAME")),
		@AttributeOverride(name="pincode", column=@Column(name="JOB_PIN_CODE"))
	})
	private Address jobAddress;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS", joinColumns=@JoinColumn(name="user_id") )
	Set<Address> adresses = new HashSet<Address>();
	
	@ElementCollection
	@JoinTable(name="USER_BOOK", joinColumns=@JoinColumn(name="user_id"))
	@GenericGenerator(name="hilo-gen", strategy="hilo")
	@CollectionId(columns={@Column(name="BOOK_ID")},generator="hilo-gen",type=@Type(type="long"))
	Collection<Book> books = new ArrayList<Book>();
	
	
	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}

	public Set<Address> getAdresses() {
		return adresses;
	}
	
	public void setAdresses(Set<Address> adresses) {
		this.adresses = adresses;
	}
	
	
	public Address getJobAddress() {
		return jobAddress;
	}
	public void setJobAddress(Address jobAddress) {
		this.jobAddress = jobAddress;
	}
	public Address getAddress() {
		return homeAddress;
	}
	public void setAddress(Address address) {
		this.homeAddress = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joineDate) {
		this.joinDate = joineDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
