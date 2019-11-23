package edu.mum.gof.service;

import java.util.List;

import edu.mum.gof.domain.Authority;
import edu.mum.gof.domain.User;

public interface UserService {
	
	public void save(User user);
	public User findByUserName(String userName);
	public List<User> findAll();
	public User login(String password, String userName);
	public List<Authority> getRoles(String userName);
}
