package edu.mum.gof.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.gof.domain.Billing;
import edu.mum.gof.repository.RoomRepository;
import edu.mum.gof.utill.BookingUtil;

@Controller
@SessionAttributes("room")
public class BillingController {
	@Autowired
	private RoomRepository roomRepository; 
	
	@GetMapping(value = "/Billing/billing")
	public String addPaymentForm(@RequestParam("beginningDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate beginningDate, 
			@RequestParam("endingDate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endingDate, 
			@RequestParam("id") Long id , Model model) {
		model.addAttribute("room", roomRepository.findOne(id));
		model.addAttribute("billing", new Billing());
		model.addAttribute("dateDiff", BookingUtil.getDayDifference(beginningDate, endingDate));
		model.addAttribute("beginningDate", beginningDate);
		model.addAttribute("endingDate", endingDate);
		return "billingForm";
		
	}
	
	@PostMapping(value = "/Billing/payment")
	public String savePayment(@Valid @ModelAttribute("billing") Billing billing, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) {
			return "billingForm";
		}
		return "redirect:/Billing/thankyou";
	}
	@GetMapping(value="/Billing/thankyou")
	public String thankYou() {
		return "thankyou";
	}
}
