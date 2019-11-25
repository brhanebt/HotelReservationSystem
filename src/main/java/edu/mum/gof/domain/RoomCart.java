package edu.mum.gof.domain;

import java.time.LocalDate;
import java.util.Date;

import edu.mum.gof.utill.BookingUtil;

public class RoomCart {
	private Room room;
	private LocalDate startDate; 
	private LocalDate endDate; 
	public RoomCart() {
		
	}
	public RoomCart(Room room) {
		this.room=room;
	}
	public RoomCart(Room room, LocalDate startDate, LocalDate endDate) {
		this.room= room;
		this.startDate= startDate; 
		this.endDate=endDate; 
	}
	public Double getTotalCost() {
		try {
			return this.room.getBasePrice() * this.getDayDifference();
		}catch(Exception e) {
			return null; 
		}
	}
	public Double getTotalTax() {
		try {
			return BookingUtil.getTaxableAmountOf(this.getTotalCost());
		}catch(Exception e) {
			return null; 
		}	
	}
	public Long getDayDifference () {
		return BookingUtil.getDayDifference(this.startDate, this.endDate);
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
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
	public String getStringStartDate () {
		return BookingUtil.getStringDate(this.startDate);
	}
	public String getStringEndDate () {
		return BookingUtil.getStringDate(this.startDate);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((room == null) ? 0 : room.hashCode());
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
		RoomCart other = (RoomCart) obj;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		return true;
	}
	
}
