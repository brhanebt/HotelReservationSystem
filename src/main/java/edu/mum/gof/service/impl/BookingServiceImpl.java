package edu.mum.gof.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.gof.domain.Room;
import edu.mum.gof.repository.RoomRepository;
import edu.mum.gof.service.BookingService;
import edu.mum.gof.service.RoomService;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{
	
	@Autowired private RoomRepository bookingRepository;
	 

	 
	 public List<Room> findAll() {
	 
	 return (List<Room>)bookingRepository.findAll(); }
	 
	

}
