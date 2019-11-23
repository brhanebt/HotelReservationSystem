package edu.mum.gof.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Booking implements Serializable{

	private static final long serialVersionUID = -1638714413916571278L;
	@Id
	private Long id;
	
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@NotNull(message="startdate.cannotnull.")
	private LocalDate startDate;
	 
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@NotNull(message="enddate.cannotnull.")
	private LocalDate endDate;
	@NotNull (message="types.of.room")
//	private List<Room> typeOfRoom;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	/*
	 * public List<Room> getListOfRoom() { return typeOfRoom; } public void
	 * setListOfRoom(List<Room> typeOfRoom) { this.typeOfRoom = typeOfRoom; }
	 */
}
