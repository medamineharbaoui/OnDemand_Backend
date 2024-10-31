package tn.homejek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tn.homejek.model.Booking;
import tn.homejek.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/rest/api/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/add")
    public ResponseEntity<Booking> add (@RequestBody Booking booking){
        try {
            booking = bookingService.addBooking(booking);
            return ResponseEntity.ok(booking);
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Booking> getOneById(@PathVariable Long id){
        return ResponseEntity.ok(bookingService.getBooking(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Booking>> getAll(){
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/getForClient/{clientId}")
    public ResponseEntity<List<Booking>> getForClient (@PathVariable Long clientId){
        return ResponseEntity.ok(bookingService.getClientBookings(clientId));
    }

    @GetMapping("/getForSP/{spId}")
    public ResponseEntity<List<Booking>> getForSP (@PathVariable Long spId){
        return ResponseEntity.ok(bookingService.getServiceProviderBookings(spId));
    }

    @PostMapping("/accept")
    public ResponseEntity<Booking> accept (@RequestParam Long bookingId,@RequestParam Long spId){
        try {
            Booking booking = bookingService.acceptBooking(bookingId,spId);
            return ResponseEntity.ok(booking);
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
