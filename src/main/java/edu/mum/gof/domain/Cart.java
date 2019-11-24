package edu.mum.gof.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<RoomCart> list; 
	private Customer customer; 
	public Cart() {
		this.list= new ArrayList<RoomCart>();
	}
	public Double ComputeTotalCost() {
		if(this.isEmpty())
			return null; 
		Double sum=0.0; 
		for(RoomCart roomCart: this.list)
			sum+= roomCart.getTotalCost();
		return sum; 
	}
	public Double computeTotalTax() {
		if(this.isEmpty())
			return null; 
		Double sum=0.0; 
		for(RoomCart roomCart: this.list)
			sum+= roomCart.getTotalTax();
		return sum; 		
	}
	public void addRoomCart(RoomCart roomCart) {
		if(this.list == null)
			this.list= new ArrayList<RoomCart>();
		this.list.add(roomCart);
	}
	public void addRoom(Room room) {
		this.addRoomCart(new RoomCart(room));
	}
	public Room removeRoomCart(Room room) {
		if(this.isEmpty())
			return null; 
		
		return null; 
	}
	public void removeCarts () {
		this.removeCarts();
	} 
	public List<RoomCart> getRoomCarts() {
		return this.list;
	}
	public Customer getCustomer() {
		return this.customer;
	}
	public void setCustomer(Customer customer)  {
		this.customer=customer; 
	}
	public boolean existsRoom(Room room)  {
		if(this.isEmpty() || room == null)
			return false; 
		RoomCart rmC= new RoomCart(room);
		for(RoomCart roomCart: this.list)
			if(roomCart.equals(rmC))
				return true;
		return false; 
	}
	public boolean isEmpty() {
		return ((this.list == null)||(this.list.size() <= 0 ));
	}
	public boolean emptyCart() {
		this.list=null; 
		return true; 
	}
	public List<RoomCart> getList() {
		return list;
	}
	public void setList(List<RoomCart> list) {
		this.list = list;
	}
	
}
