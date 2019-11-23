package edu.mum.gof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.mum.gof.domain.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	@Query("Select r from Room r where r.roomNumber = ?1")
	public Room findByRoomNumber(String roomNumber);

}
