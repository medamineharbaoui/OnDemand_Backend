package tn.homejek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.homejek.model.Booking;
import tn.homejek.model.BookingStatus;
import tn.homejek.repository.BookingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImp implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBooking(Long bookingId) {
        return bookingRepository.findById(bookingId).get();
    }

    @Override
    public void updateBookingStatus(Long bookingId, BookingStatus status) {
        Booking booking = bookingRepository.findById(bookingId).get();
        booking.setStatus(status);
        bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return null;
    }

    @Override
    public List<Booking> getClientBookings(Long clientId) {
        return bookingRepository.findAll().stream()
                .filter(elt -> elt.getClient().getId() == clientId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Booking> getServiceProviderBookings(Long serviceProviderId) {
        return null;
    }

    @Override
    public Booking acceptBooking(Long bookingId, Long spId) {
        return null;
    }
}
