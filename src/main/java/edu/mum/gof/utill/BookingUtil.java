package edu.mum.gof.utill;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.mum.gof.domain.Room;
import edu.mum.gof.domain.RoomCart;

public class BookingUtil {
	public static Long getDayDifference(LocalDate startDate, LocalDate endDate) {
		try {
			Period intervalPeriod = Period.between(startDate, endDate); 
			return Math.abs((long) intervalPeriod.getDays());
		}catch(Exception e) {
			return null; 
		}
	}
	public static Double getTotalCost(Room room, LocalDate startDate, LocalDate endDate) { 
		if(room == null || startDate == null || endDate == null)
			return null;
		try {
			return (room.getBasePrice() * getDayDifference(startDate, endDate));
		}catch(Exception e) {
			return null;
		}
	}
	public static Double getTotalTax(Room room, LocalDate startDate, LocalDate endDate) {
		return getTaxableAmountOf(getTotalCost(room, startDate, endDate));
	}
	public static List<RoomCart> getRoomCartListOf(List<Room> rooms, LocalDate startDate, LocalDate endDate) {
		if(rooms == null)
			return null; 
		if(rooms.size() <= 0 )
			return null; 
		List<RoomCart> list= new ArrayList<RoomCart>();
		for(Room room: rooms ) {
			list.add(new RoomCart(room, startDate, endDate)); 
		}
		return list; 
		
	}
	public static Double getTaxPercentage() {
		return 0.15;
	}
	public static Double getTaxableAmountOf(Double price) {
		try {
			return (price * getTaxPercentage());
		}catch(Exception e) {
			return null; 
		}
	}
	public static LocalDate getToday() {
		LocalDate today = LocalDate.now(); 
		return today; 
	}
	public static LocalDate getTomorrow() {
		return (getToday().plusDays(1)); 
	}

	public static String getStringDate(LocalDate date) {
		try {
			return date.toString();
		}catch(Exception e) {
			return null;
		}
	}
}
