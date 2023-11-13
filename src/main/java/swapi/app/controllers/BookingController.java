package swapi.app.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<?> postBooking(@PathVariable(required = false, name = "vip") String vip, @RequestBody BookingDto bookingDto) {
        BookingEntity bookingEntity = bookingMapper.mapFrom(bookingDto);
        var result = bookingService.createBooking(bookingEntity, vip);
        if(result == null)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(bookingMapper.mapTo(bookingEntity), HttpStatus.CREATED);
    }
}
