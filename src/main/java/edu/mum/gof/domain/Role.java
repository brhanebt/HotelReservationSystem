package edu.mum.gof.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "auth_role")
public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8361752408041717029L;

	public Role() {};
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auth_role_id")
	private int id;

	@Column(name = "role_name")
	private String role;

	@Column(name = "role_desc")
	private String desc;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_role_id"), inverseJoinColumns = @JoinColumn(name = "auth_user_id"))
	private List<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", desc=" + desc + ", users=" + users + "]";
	}
	
}