package edu.mum.gof.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.gof.domain.Customer;
import edu.mum.gof.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@RequestMapping({"/Customers", "list"})
	public String listCustomer(Model model) {
		model.addAttribute("customers", this.customerService.findAll());
		return "list_customers";
	}
	@RequestMapping(value="/Customer/view", method=RequestMethod.GET)
	public String viewCustomer() {
		
		return "viewCustomer";
	}	
	@RequestMapping(value="/Customer/add", method=RequestMethod.GET)
	public String addCustomer(@ModelAttribute("customer") Customer customer, Model model) {
		
		return "addCustomer";
	}
	
	@RequestMapping(value="/Customer/add", method=RequestMethod.POST)
	public String processAddCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, RedirectAttributes redAttrib) {
		
		if(result.hasErrors() ) {
			return "addCustomer";
		}
		try {
			customer= this.customerService.save(customer);
		}catch(Exception e) {
			return "addCustomer";
		}
//		System.out.println("id: " + customer.getId());
		redAttrib.addFlashAttribute("customer", customer); 
		redAttrib.addFlashAttribute("opType", "New");
		
		return "redirect:/Customer/view";
	}
	
	@RequestMapping(value="/Customer/edit/{id}", method=RequestMethod.GET)
	public String editCustomer(@PathVariable("id") Long id, Model model) {
//		Customer customer= this.customerService.findOne(id); 
//		if(customer == null ) {
//			System.out.println("Id not wrong. sorry, very much.");
//			return "customers/";
//		}
//		model.addAttribute("customer", customer);
//		return "customer/editCustomer";
		Customer customer= this.customerService.findOne(id); 
		model.addAttribute("customer", customer);
		if(customer == null ) {
			System.out.println("Id not wrong. sorry, very much.");
			return "Customers";
		}
		return "editCustomer";
	}
	
	@RequestMapping(value="/Customer/edit", method=RequestMethod.POST)
	public String processEditCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, RedirectAttributes redAttrib) {
		
		if(result.hasErrors() ) {
			return "editCustomer";
		}
		
		redAttrib.addFlashAttribute("customer", customer); 
		redAttrib.addFlashAttribute("opType", "Edit");
		
		return "redirect:/Customer/view";
	}
	@RequestMapping(value="/Customer/delete/{id}", method=RequestMethod.GET)
	public String deleteCustomer(@PathVariable("id") Long id) {
		Customer customer= this.customerService.findOne(id); 
		this.customerService.delete(customer);
		return "redirect:/Customers";
	}
}
