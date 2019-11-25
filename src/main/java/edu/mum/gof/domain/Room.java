package edu.mum.gof.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Room implements Serializable{

  private static final long serialVersionUID = 6104382503793665292L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message = "{NotEmpty}")
	private String roomNumber;
	@NotNull(message = "{NotNull}")
	private Integer floorNumber;
	
	@NotNull(message = "{NotNull}")
	@Min(value= 1, message = "{Size.min}")
	private Double basePrice;
	@NotNull(message = "{NotNull}")
	@Min(value= 1, message = "{Size.min}")
	private Integer numBeds;
	
	private boolean smoking;
	
	private boolean windows;
	
	private boolean airConditioning;
	
	@OneToMany(mappedBy="room")
	List<Booking> bookings; 
	
	public void addBooking(Booking booking) {
		if(this.bookings == null)
			this.bookings= new ArrayList<Booking>();
		this.bookings.add(booking);
	}
	public void removeBooking(Booking booking) {
		if(bookings == null || this.bookings == null || this.bookings.size() <= 0 )
			return; 
		try {
			this.bookings.remove(booking);
		}catch(Exception e) {
			return; 
		}
	}
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Integer getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}

	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	public Integer getNumBeds() {
		return numBeds;
	}

	public void setNumBeds(Integer numBeds) {
		this.numBeds = numBeds;
	}

	public boolean isAirConditioning() {
		return airConditioning;
	}

	public void setAirConditioning(boolean airConditioning) {
		this.airConditioning = airConditioning;
	}

	public boolean isWindows() {
		return windows;
	}

	public void setWindows(boolean windows) {
		this.windows = windows;
	}

	public boolean isSmoking() {
		return smoking;
	}

	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}
	// Benyam added

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
		Room other = (Room) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}