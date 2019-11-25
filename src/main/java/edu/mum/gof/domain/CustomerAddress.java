package edu.mum.gof.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class CustomerAddress {
	public final int HomeAddress=1; 
	public final int BillingAddress=2; 
	public final int WorkAddress= 3;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id; 
	
	@NotEmpty(message="{notEmptyField}")
	@Column(name="street")
	private String street; 
	
	@Column(name="apartmentNumber")	
	private String apartmentNumber; 
	
	@NotEmpty(message="{notEmptyField}")
	@Column(name="city")	
	private String city; 
	
	@NotEmpty(message="{notEmptyField}")
	@Column(name="state")	
	private String state; 
	
	@NotEmpty(message="{notEmptyField}")
	@Column(name="zipCode")	
	private String zipCode;
	
	@JoinColumn(name="customer_id")
	private Customer customer; 
	
	@Column(name="addressType")
	private Integer addressType= HomeAddress; 
	
	public CustomerAddress() {
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getAddressType() {
		return addressType;
	}
	public void setAddressType(Integer addressType) {
		this.addressType = addressType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerAddress other = (CustomerAddress) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
