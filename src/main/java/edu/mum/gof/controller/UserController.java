package edu.mum.gof.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.gof.domain.Login;
import edu.mum.gof.domain.Registration;
import edu.mum.gof.domain.Role;
import edu.mum.gof.domain.User;
import edu.mum.gof.service.UserService;

@Controller
@SessionAttributes("userLogin")
@RequestMapping(value = "/user")
public class UserController {
	
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginPage(@Valid Model model) {
		model.addAttribute("user",new Login());
		return "login";
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("user") Login user, BindingResult result, Model model,
				RedirectAttributes redirectAttributes,HttpServletRequest request) {
		model.addAttribute("errorMsg", "");
		if (result.hasErrors()) {
			return "login";
		}
		if (!service.checkUserExist(user.getUserName(), user.getPassword())) {
			model.addAttribute("errorMsg", "User Name or Password is Wrong!");
			return "login";
		}
		request.getSession().setAttribute("userLogin", true);
		redirectAttributes.addFlashAttribute("user", user);
		return "redirect:/user/userHome";
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signupForm(Model model) {
		List<String> roles = service.getDefaultRoles().stream().map(Role::getRole).collect(Collectors.toList());
		model.addAttribute("roles", roles);
		model.addAttribute("registration", new Registration());
		return "signup";
	}
	
	//signup post method
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute("registration") Registration registration, BindingResult result, Model model,
			RedirectAttributes redirectAttributes,HttpServletRequest request) {
		if (result.hasErrors()) {
			return "signup";
		}
		
		if (!registration.getVerifyPassword().equals(registration.getUser().getPassword())) {
			result.rejectValue("verifyPassword", "user.verifyPassword");
			return "signup";
		}
		User user = service.getUserFromRegistration(registration);
		service.save(user);
		request.getSession().setAttribute("userLogin", true);
		redirectAttributes.addFlashAttribute("user", user);		
		return "redirect:/user/userHome";
	}
	
	@RequestMapping(value="/userHome", method = RequestMethod.GET)
	public String userHome() {
		return "user";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().setAttribute("userLogin", false);
		return "redirect:/Booking";
	}

}