package com.tickettrack.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tickettrack.entity.TEntity;
import com.tickettrack.service.TService;

@Controller
public class HomeController {
	
	@Autowired
	private TService service;
	@GetMapping("/")
	public String home(Model m)
	{
		
		
		List<TEntity> ticket=service.getAllTicket();
		m.addAttribute("ticket",ticket);
		return "index";
	}
	
	@GetMapping("/addticket")
	public String addTicketForm()
	{
		return "add_ticket";
	}
	
	@PostMapping("/register")
	public String ticketRegister(@ModelAttribute TEntity t, HttpSession session)
	{
		System.out.println(t);
			
		service.addTicket(t);
		
		session.setAttribute("msg", "Ticket Generated Successfull...");
		return "redirect:/";
	}
	@GetMapping("/editticket/{id}")
	public String editTicket(@PathVariable Long id,Model m)	
	{
		TEntity t=service.getTicketById(id);
		m.addAttribute("ticket",t);
		
		return "edit";
	}
	@PostMapping("/update")
	public String ticketUpdate(@ModelAttribute TEntity t, HttpSession session)
	{
					
		service.addTicket(t);
		
		session.setAttribute("msg", "Ticket Updated Successfull...");
		return "redirect:/";
	}
	@GetMapping("/deleteticket/{id}")
	public String deleteTicket(@PathVariable Long id,HttpSession session)
	{
		service.deleteTicket(id);
session.setAttribute("msg", "Ticket Deleted...");
		
return "redirect:/"; 
	}





}
