package com.tickettrack.start.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tickettrack.start.entity.TEntity;
import com.tickettrack.start.repository.TRepo;

@Controller
public class TController {

	@Autowired
	private TRepo ticketrepo;

	@GetMapping("/")
	public String home(Model m) {
		List<TEntity> list = ticketrepo.findAll();
		m.addAttribute("all_ticket", list); // diffrence not addAllAttribute

		return "index";
	}

	@GetMapping("/load_form")
	public String loadForm() {
		return "a_create_ticket";
	}

	@GetMapping("/edit_form/{id}")
	public String editForm(@PathVariable(value = "id") Long id, Model m) {

		Optional<TEntity> ticket = ticketrepo.findById(id);
		TEntity tt = ticket.get();
		m.addAttribute("ticket", tt);

		return "c_update_ticket";
	}

	@PostMapping("save_ticket")
	public String saveTicket(@ModelAttribute TEntity ticket, HttpSession session) {

		ticketrepo.save(ticket);
		session.setAttribute("msg", "Ticket Added Successfully");
		return "redirect://load_form";
	}

	@PostMapping("update_ticket")
	public String updateTicket(@ModelAttribute TEntity ticket, HttpSession session) {

		ticketrepo.save(ticket);
		session.setAttribute("msg", "Ticket Updated Successfully");
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteTicket(@PathVariable(value = "id") Long id, HttpSession session) {
		ticketrepo.deleteById(id);
		session.setAttribute("msg", "Ticket deleted");
		return "redirect:/";
	}

}
