package edu.mum.gof.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.gof.domain.Customer;
import edu.mum.gof.repository.CustomerRepository;
import edu.mum.gof.service.CustomerService;

@Service
@Transactional 
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository; 
	@Override
	public Customer findOne(Long id) {
		return this.customerRepository.findOne(id); 
	}

	@Override
	public List<Customer> findAll() {
		return (List<Customer>) this.customerRepository.findAll();
	}

	@Override
	public Customer save(Customer customer) {
		return this.customerRepository.save(customer);
	}

	@Override
	public void delete(Customer customer) {
		this.customerRepository.delete(customer);
	}

	@Override
	public Long count() {
		return this.customerRepository.count();
	}

	@Override
	public boolean exists(Long id) {
		return this.customerRepository.exists(id); 
	}
}
