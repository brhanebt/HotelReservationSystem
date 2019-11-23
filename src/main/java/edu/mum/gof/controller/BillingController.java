package edu.mum.gof.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.gof.domain.Billing;

@Controller
public class BillingController {
	
	
	@GetMapping(value = "/Billing/billing")
	
	public String addPayment(Model model) {
		
		model.addAttribute("payment", new Billing());
		
		return "billingForm";
		
	}
}
