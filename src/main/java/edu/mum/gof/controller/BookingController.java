package edu.mum.gof.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.gof.domain.Billing;
import edu.mum.gof.domain.Booking;
import edu.mum.gof.domain.BookingFilter;
import edu.mum.gof.service.RoomService;
import edu.mum.gof.utill.BookingUtil;

@Controller
public class BookingController {

	@Autowired
	private RoomService roomService;

	@GetMapping({ "/","/Booking" })
	public String roomAvailabilityForm(@ModelAttribute("bookingFilter") BookingFilter bookingFilter, Model model) {
		bookingFilter.setBeginningDate(BookingUtil.getToday().toString());
		bookingFilter.setEndingDate(BookingUtil.getTomorrow().toString());
		model.addAttribute("bookingFilter", bookingFilter); 
		model.addAttribute("rooms", roomService.getAllRooms());
		model.addAttribute("beginningDate", bookingFilter.getBeginningDate()); 
		model.addAttribute("endingDate", bookingFilter.getEndingDate());		
		return "bookingRoom";
	}
	@PostMapping("/Booking" )
	public String filterAvailabilityForm(@ModelAttribute("bookingFilter") BookingFilter bookingFilter, Model model) {
		model.addAttribute("reservation", new Booking());
		model.addAttribute("beginningDate", bookingFilter.getBeginningDate()); 
		model.addAttribute("endingDate", bookingFilter.getEndingDate()); 
		model.addAttribute("rooms", roomService.getAllRooms());
		return "bookingRoom";
	}
	@RequestMapping("/Booking/{id}")
	public String getRoom(@PathVariable("id") Long id, Model model, RedirectAttributes redirect) {
		System.out.println(id);
		model.addAttribute("newbill", new Billing());
		model.addAttribute("room", roomService.getRoom(id));
		return "billingForm";
	}
}