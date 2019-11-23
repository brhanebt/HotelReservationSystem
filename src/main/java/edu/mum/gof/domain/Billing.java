package edu.mum.gof.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Billing implements Serializable{

	private static final long serialVersionUID = -8058610230929807462L;

	@Id
	private Long id;
	
	@NotNull
	@Size(min=3, max=10, message="billing.firstName.can.notbe.null")
	private String firstName;
	@NotNull
	@Size(min=3, max=10, message="billing.lastName.can.notbe.null")
	private String lastName;
	@NotNull(message="billing.numberOnCard.can.notbe.null")
	private Integer noOnCard;
	@NotNull
	private Integer securityCode;
	@NotNull(message="billing.ExpireDate.Not.Null")
	private Date expireDate;
	@NotNull
	@Email(message="billing.Email.Not.Null")
	private String email;
	
	@NotNull(message="billing.phoneNum.Not.Null")
	private Integer phoneNumber;
	
	
	
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
	public Integer getNoOnCard() {
		return noOnCard;
	}
	public void setNoOnCard(Integer noOnCard) {
		this.noOnCard = noOnCard;
	}
	public Integer getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(Integer securityCode) {
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
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
