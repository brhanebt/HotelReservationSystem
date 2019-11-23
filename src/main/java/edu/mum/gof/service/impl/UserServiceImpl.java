package edu.mum.gof.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mum.gof.domain.Authority;
import edu.mum.gof.domain.User;
import edu.mum.gof.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String password, String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Authority> getRoles(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
