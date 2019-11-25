package edu.mum.gof.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Billing implements Serializable{

	private static final long serialVersionUID = -8058610230929807462L;

	@Id
	private Long id;
	
	
	@Size(min=3, max=10, message="{Siz.name.validation}")
	private String firstName;
	@Size(min=3, max=15, message="{Siz.name.validation}")
	private String lastName;
	@NotEmpty(message="{NotEmpty}")
	private String noOnCard;
	@NotEmpty(message = "{NotEmpty}")
	private String securityCode;
	@NotNull(message="{NotNull}")
	private Date expireDate;
	@NotEmpty(message="{NotEmpty}")
	@Email(message="{invalidEmailField}")
	private String email;
	
	@NotEmpty(message="{NotEmpty}")
	private String phoneNumber;
	
	
	
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
	public String getNoOnCard() {
		return noOnCard;
	}
	public void setNoOnCard(String noOnCard) {
		this.noOnCard = noOnCard;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
