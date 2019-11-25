package edu.mum.gof.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name="room_id")
	private Room room; 
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer; 
	
	private boolean isActive=false; 
	
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
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public void turnOn() {
		this.isActive=true; 
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
