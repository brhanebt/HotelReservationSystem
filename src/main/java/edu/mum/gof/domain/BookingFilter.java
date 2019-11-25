package edu.mum.gof.domain;

public class BookingFilter {
	private String beginningDate; 
	private String endingDate; 
	public BookingFilter() {}
	public String getBeginningDate() {
		return beginningDate;
	}
	public void setBeginningDate(String beginningDate) {
		this.beginningDate = beginningDate;
	}
	public String getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(String endingDate) {
		this.endingDate = endingDate;
	}
	
}
