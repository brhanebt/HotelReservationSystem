package edu.mum.gof.domain;

import java.util.Date;

import edu.mum.gof.utill.BookingUtil;

public class RoomCart {
	private Room room;
	private Date startDate; 
	private Date endDate; 
	public RoomCart() {
		
	}
	public RoomCart(Room room, Date startDate, Date endDate) {
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStringStartDate () {
		return BookingUtil.getStringDate(this.startDate);
	}
	public String getStringEndDate () {
		return BookingUtil.getStringDate(this.startDate);
	}
}
