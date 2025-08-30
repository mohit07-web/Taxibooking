package com.taxibooking.service;

import java.util.List;

import com.taxibooking.model.BookingForm;
import com.taxibooking.model.ContactForm;

public interface BookingFormService {

	public BookingForm saveBookingFormService(BookingForm bookingForm);
	public List<BookingForm> readAllBookingService();
	public void deleteBookingService(int id);
}
