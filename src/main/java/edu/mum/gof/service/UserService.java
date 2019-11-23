package edu.mum.gof.service;

import java.util.List;

import edu.mum.gof.domain.Registration;
import edu.mum.gof.domain.Role;
import edu.mum.gof.domain.User;

public interface UserService {
	
	public void save(User user);
	public User findById(Long id);
	public List<User> findAll();
	public List<Role> getRoles(Long userId);
	public List<Role> getDefaultRoles();
	
	public User findByUserName(String userName);
	public Boolean checkUserExist(String userName, String password);
	public User getUserFromRegistration(Registration registration);
	
}
