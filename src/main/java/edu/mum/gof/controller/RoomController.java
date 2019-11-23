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


import edu.mum.gof.domain.Room;
import edu.mum.gof.service.RoomService;

@Controller
public class RoomController {
	@Autowired
	private RoomService roomService;
	@RequestMapping("/Rooms")
	public String listRooms(Model model) {
		model.addAttribute("rooms", roomService.getAllRooms());
		return "rooms";
	}
	
	@RequestMapping(value = {"/Room/addRoom"})
	public String addRoom(Model model) {
		model.addAttribute("room", new Room());
		return "addRoom";
	}
	@RequestMapping(value = {"/Room/editRoom"})
	public String editRoomForm(Model model) {
		return "editRoom";
	}
	@RequestMapping(value = {"/Room/editRoom"}, method = RequestMethod.POST)
	public String editRoom(@Valid @ModelAttribute Room room, BindingResult result, Model model) {
		model.addAttribute("room",room);
		return "editRoom";
	}
	@RequestMapping(value = {"/Room/edit/{id}"})
	public String editRoom(@PathVariable("id") Long id, Model model) {
		model.addAttribute("room",roomService.getRoom(id));
		return "editRoom";
	}
	@RequestMapping(value = {"/Room/delete/{id}"})
	public String deleteRoom(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message","Room number " +roomService.getRoom(id).getRoomNumber() + " Successfully deleted!");
		roomService.deleteRoom(id);
		return "redirect:rooms";
	}
	
	
	@RequestMapping(value = {"/Room/addRoom"}, method = RequestMethod.POST)
    public String addRoom(@Valid @ModelAttribute("room") Room room, 
    		BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			return "addRoom";
		}
		try {
			roomService.saveUpdate(room);
		}
		catch(Exception ex) {
			return "addRoom";
		}
		redirectAttributes.addFlashAttribute("message","Room number " +room.getRoomNumber() + " Successfully Saved!");
		return "redirect:/Rooms";
    }
	
	
}
