package edu.mum.gof.domain;

import java.io.Serializable;
import java.util.Set;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Registration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2028174343996087451L;

	public Registration() {}
	
	@Valid
	public User user;
	
	@NotBlank
	private String verifyPassword;
	
	@NotEmpty
	private Set<String> rolesArr;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public Set<String> getRolesArr() {
		return rolesArr;
	}

	public void setRolesArr(Set<String> rolesArr) {
		this.rolesArr = rolesArr;
	}
	
}
