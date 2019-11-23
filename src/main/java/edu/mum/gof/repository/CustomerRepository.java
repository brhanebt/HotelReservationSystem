package edu.mum.gof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.gof.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
