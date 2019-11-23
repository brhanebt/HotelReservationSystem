package edu.mum.gof.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.gof.domain.Registration;
import edu.mum.gof.domain.Role;
import edu.mum.gof.domain.User;
import edu.mum.gof.repository.RoleRepository;
import edu.mum.gof.repository.UserRepository;
import edu.mum.gof.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void save(User user) {
		repository.save(user);
	}

	@Override
	public User findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<User> findAll() {
		return (List<User>)repository.findAll();
	}

	@Override
	public User findByUserName(String userName) {
		return repository.findByUserName(userName);
	}

	@Override
	public List<Role> getRoles(Long userId) {
		return roleRepository.getAllRolesByUserId(userId);
	}
	
	@Override
	public List<Role> getDefaultRoles() {
		return StreamSupport.stream(roleRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}
	
	@Override
	public Boolean checkUserExist(String userName, String password) {
		return repository.findByUserNameAndPassword(userName, password) != null;
	}

	@Override
	public User getUserFromRegistration(Registration registration) {
		registration.user.setStatus("ACTIVE");
		Set<Role> roles = new HashSet<>();
		for (Role role : this.getDefaultRoles()) {
			for (String roleName : registration.getRolesArr()) {
				if (role.getRole().equals(roleName)) {
					roles.add(role);
				}
			}
		}
		registration.user.setRoles(roles);
		return registration.user;
	}
	
}
