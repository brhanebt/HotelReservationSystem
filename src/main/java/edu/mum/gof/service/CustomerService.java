package edu.mum.gof.service;

import java.util.List;

import edu.mum.gof.domain.Customer;

public interface CustomerService {
	public Customer findOne(Long id); 
	public List<Customer> findAll(); 
	public Customer save(Customer customer); 
	public void delete(Customer customer); 
	public Long count();
	public boolean exists(Long id); 
}
