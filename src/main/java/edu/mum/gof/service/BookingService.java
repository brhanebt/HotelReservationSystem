package edu.mum.gof.service;

import java.time.LocalDate;
import java.util.List;

import edu.mum.gof.domain.Room;

public interface BookingService {
	public List<Room> findAll();
	public List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate);
	public List<Room> getAvailableRooms(LocalDate startDate); 
}
