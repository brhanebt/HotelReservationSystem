package edu.mum.gof.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message="{notEmptyField}")
	@Column(name="firstName")
	private String firstName; 
	
	@NotEmpty(message="{notEmptyField}")
	@Column(name="lastName")
	private String lastName; 
	
	@Email(message="{invalidEmailField}")
	@Column(name="email")
	private String email; 
	
	@Column(name="telephone")
	private String telephone; 
	
//	@OneToMany(mappedBy="customer")
//	private List<CustomerAddress> addresses; 
	
	
	public Customer() {
		
	}
//	public void addAddress(CustomerAddress address) {
//		this.addresses.add(address); 
//	}
//	public boolean removeAddress(CustomerAddress address) {
//		try {
//			return (true == this.addresses.remove(address)); 
//		}catch(Exception e) {
//			return false; 
//		}
//	}
//	public List<CustomerAddress> getAddresses() {
//		return addresses;
//	}
//	public void setAddresses(List<CustomerAddress> addresses) {
//		this.addresses = addresses;
//	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
