package edu.mum.gof.service;

import java.util.List;

import edu.mum.gof.domain.Room;

public interface RoomService {
	public List<Room> getAllRooms();
    public Room getRoom(Long id);
    public Room saveUpdate(Room room);
	public Room getRoomByRoomNumber(String roomNumber);
	public void deleteRoom(Long id);
}
