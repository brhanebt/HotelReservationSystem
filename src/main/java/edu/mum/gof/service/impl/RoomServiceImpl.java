package edu.mum.gof.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.gof.domain.Room;
import edu.mum.gof.repository.RoomRepository;
import edu.mum.gof.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public List<Room> getAllRooms() {	
		return roomRepository.findAll();
	}

	@Override
	public Room getRoom(Long id) {
		return roomRepository.findOne(id);
	}

	@Override
	public Room saveUpdate(Room room) {
		return roomRepository.save(room);
	}

	@Override
	public Room getRoomByRoomNumber(String roomNumber) {
		return roomRepository.findByRoomNumber(roomNumber);
	}

	@Override
	public void deleteRoom(Long id) {
		roomRepository.delete(id);
	}

}
