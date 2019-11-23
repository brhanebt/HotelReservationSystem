package edu.mum.gof.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import edu.mum.gof.domain.Booking;


@Controller
public class BookingController {
  
	@GetMapping({"/Booking/Booking"})
	public String roomAvailabilityForm(Model model) {
				
		model.addAttribute("reservation",new Booking());
		return "bookingRoom";
	}
	
}
