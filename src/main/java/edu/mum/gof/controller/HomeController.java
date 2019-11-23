package edu.mum.gof.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
  
@Controller
public class HomeController {

	@RequestMapping({"/","/home"})
	public String welcome(Model model) {

		return "home";
	}
}
