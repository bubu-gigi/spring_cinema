package swapi.app.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swapi.app.domain.dto.BookingDto;
import swapi.app.domain.entities.BookingEntity;
import swapi.app.mappers.Mapper;
import swapi.app.services.BookingService;

import java.util.Optional;

@RestController
public class BookingController {

    private final BookingService bookingService;
    private final Mapper<BookingEntity, BookingDto> bookingMapper;

    public BookingController(BookingService bookingService, Mapper<BookingEntity, BookingDto> bookingMapper) {
        this.bookingService = bookingService;
        this.bookingMapper = bookingMapper;
    }

    @PostMapping(path = "/api/bookings/{vip}")
    public ResponseEntity<?> postBooking(@PathVariable(name = "vip", required = false) String vip, @RequestBody BookingDto bookingDto) {
        BookingEntity bookingEntity = bookingMapper.mapFrom(bookingDto);
        var result = bookingService.createBooking(bookingEntity, vip);
        if(result.isEmpty())
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(bookingMapper.mapTo(bookingEntity), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/api/bookings/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable(name = "id") Integer id) {
        Optional<BookingEntity> bookingEntity = bookingService.findById(id);
        if(bookingEntity.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        bookingService.deleteById(bookingEntity.get().getId());
        return new ResponseEntity<>(bookingEntity, HttpStatus.OK);
    }
}
