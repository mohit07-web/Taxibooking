package com.taxibooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taxibooking.model.BookingForm;
import com.taxibooking.model.ContactForm;
import com.taxibooking.model.ServiceForm;
import com.taxibooking.service.BookingFormService;
import com.taxibooking.service.ContactFormService;
import com.taxibooking.service.ServiceFormService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class MyController {
	
	private ContactFormService contactFormService;
	private BookingFormService bookingFormService;
	private ServiceFormService serviceFormService;
	
	
	@Autowired
	public void setServiceFormService(ServiceFormService serviceFormService) {
		this.serviceFormService = serviceFormService;
	}

	@Autowired
	public void setBookingFormService(BookingFormService bookingFormService) {
		this.bookingFormService = bookingFormService;
	}

	@Autowired
	public void setContactFormService(ContactFormService contactFormService) {
		this.contactFormService = contactFormService;
	}
	
	@GetMapping("/login")
	public String adminLoginView(HttpServletRequest request, Model model) {
		
		ServletContext servletContext=request.getServletContext();
		Object attribute= servletContext.getAttribute("logout");
		if(attribute instanceof Boolean) {
			model.addAttribute("logout", attribute);
			servletContext.removeAttribute("logout");
		}
		
		return "adminlogin";
	}

	@GetMapping(path= {"/", "home", "welcome", "index"})
	public String welcomeView(HttpServletRequest req, Model m) {
		String requestURI = req.getRequestURI();
		m.addAttribute("mycurrentpage",requestURI);
		m.addAttribute("bookingForm", new BookingForm());
		return "index";
	}
	
	@GetMapping(path= {"about"})
	public String aboutView(HttpServletRequest req, Model m) {
		String requestURI = req.getRequestURI();
		m.addAttribute("mycurrentpage",requestURI);
		return "about";
	}
	
	@GetMapping(path= {"cars"})
	public String carsView(HttpServletRequest req, Model m) {
		String requestURI = req.getRequestURI();
		m.addAttribute("mycurrentpage",requestURI);
		return "cars";
	}
	
	@GetMapping(path= {"services"})
	public String servicesView(HttpServletRequest req, Model m) {
		String requestURI = req.getRequestURI();
		m.addAttribute("mycurrentpage",requestURI);
		
		List<ServiceForm> allServices = serviceFormService.readAllServices();
		m.addAttribute("allservices", allServices);
		return "services";
	}
	
	@GetMapping(path= {"contacts"})
	public String contactsView(HttpServletRequest req, Model m) {
		String requestURI = req.getRequestURI();
		m.addAttribute("mycurrentpage",requestURI);
		m.addAttribute("contactForm",new ContactForm());
		return "contacts";
	}
	
	@PostMapping("contactsform")
	public String contactsForm (@Valid @ModelAttribute ContactForm contactForm, BindingResult bindingResult, Model m, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			m.addAttribute("bindingResult", bindingResult);
			return "contacts";
		}
		
		ContactForm saveContactFormService = contactFormService.saveContactFormService(contactForm);
		
		if(saveContactFormService!=null) {
			redirectAttributes.addFlashAttribute("message", "Message Sent Successfully");
		}
		else {
			redirectAttributes.addFlashAttribute("message", "Something went wrong");
		}
		
		return "redirect:/contacts";
}
	
	@PostMapping("bookingform")
	public String bookingForm (@Valid @ModelAttribute  BookingForm  bookingForm, BindingResult bindingResult, Model m, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			m.addAttribute("bindingResult", bindingResult);
			return "index";
		}
		else if(bookingForm.getAdult()+bookingForm.getChildren()>4) {
			m.addAttribute("message", "The total no of adult and children cannot exceed 4" );
			return "index";
		}
		
		BookingForm saveBookingFormService = bookingFormService.saveBookingFormService(bookingForm);
		
		if(saveBookingFormService!=null) {
			redirectAttributes.addFlashAttribute("message", "Booking Successfully");
		}
		else {
			redirectAttributes.addFlashAttribute("message", "Something went wrong");
		}
		
		return "redirect:/index";
}
}