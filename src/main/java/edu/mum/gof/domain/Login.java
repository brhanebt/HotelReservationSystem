package edu.mum.gof.domain;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2408606719449471573L;

	public Login() {}
	
	@NotBlank
	private String userName;
	
	@NotEmpty
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
