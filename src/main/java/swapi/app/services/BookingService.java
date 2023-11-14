package swapi.app.services;


import org.springframework.stereotype.Service;
import swapi.app.domain.entities.BookingEntity;

import java.util.Optional;

@Service
public interface BookingService {

    Iterable<BookingEntity> getBookings();
    Optional<BookingEntity> findById(Integer id);
    void deleteById(Integer id);
    Optional<BookingEntity> createBooking(BookingEntity bookingEntity, String vip);
}
