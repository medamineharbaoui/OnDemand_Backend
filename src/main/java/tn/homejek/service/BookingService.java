package tn.homejek.service;

import tn.homejek.model.Booking;
import tn.homejek.model.BookingStatus;

import java.util.List;

public interface BookingService {

    Booking addBooking(Booking booking);

    Booking updateBooking(Booking booking);

    Booking getBooking(Long bookingId);

    void updateBookingStatus(Long bookingId, BookingStatus status);

    List<Booking> getAllBookings();

    List<Booking> getClientBookings(Long clientId);

    List<Booking> getServiceProviderBookings(Long serviceProviderId);

    Booking acceptBooking(Long bookingId, Long spId);
}
