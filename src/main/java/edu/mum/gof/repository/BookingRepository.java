package edu.mum.gof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.gof.domain.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
}
