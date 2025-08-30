package com.taxibooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxibooking.dao.BookingFormCrud;
import com.taxibooking.dao.ContactFormCrud;
import com.taxibooking.model.BookingForm;
import com.taxibooking.model.ContactForm;

@Service
public class BookingFormServiceImpl implements BookingFormService {

    private final ContactFormCrud contactFormCrud;

	private BookingFormCrud bookingFormCrud;


    BookingFormServiceImpl(ContactFormCrud contactFormCrud) {
        this.contactFormCrud = contactFormCrud;
    }
	
	
	@Autowired
	public void setBookingFormCrud(BookingFormCrud bookingFormCrud) {
		this.bookingFormCrud = bookingFormCrud;
	}


	@Override
	public BookingForm saveBookingFormService(BookingForm bookingForm) {

		return bookingFormCrud.save(bookingForm);
		
		
	}


	@Override
	public List<BookingForm> readAllBookingService() {
		return bookingFormCrud.findAll();
	}


	@Override
	public void deleteBookingService(int id) {
		bookingFormCrud.deleteById(id);
	}


	

}
