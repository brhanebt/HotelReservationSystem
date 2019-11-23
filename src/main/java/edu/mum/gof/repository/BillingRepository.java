package edu.mum.gof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.gof.domain.Billing;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long>{

}
