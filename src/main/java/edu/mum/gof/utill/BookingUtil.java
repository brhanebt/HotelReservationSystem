package edu.mum.gof.utill;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.mum.gof.domain.Room;
import edu.mum.gof.domain.RoomCart;

public class BookingUtil {
	public static Long getDayDifference(Date startDate, Date endDate) {
		try {
			long difference =  (endDate.getTime()- startDate.getTime())/86400000;
	        return Math.abs(difference);			
		}catch(Exception e) {
			return null; 
		}
	}
	public static Double getTotalCost(Room room, Date startDate, Date endDate) { 
		if(room == null || startDate == null || endDate == null)
			return null;
		try {
			return (room.getBasePrice() * getDayDifference(startDate, endDate));
		}catch(Exception e) {
			return null;
		}
	}
	public static Double getTotalTax(Room room, Date startDate, Date endDate) {
		return getTaxableAmountOf(getTotalCost(room, startDate, endDate));
	}
	public static List<RoomCart> getRoomCartListOf(List<Room> rooms, Date startDate, Date endDate) {
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
	public static Date getToday() {
		Date day=new Date();
		Calendar cal= Calendar.getInstance();
		cal.setTime(day);
	    cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
	    cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
	    cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
	    cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
	    return cal.getTime();
	}
	@SuppressWarnings("deprecation")
	public static String getStringDate(Date date) {
		try {
			return date.getMonth() + "/" + date.getDate() + "/" + date.getYear();
		}catch(Exception e) {
			return null;
		}
	}
}
