package swapi.app.services.impl;


import org.springframework.stereotype.Component;
import swapi.app.domain.entities.BookingEntity;
import swapi.app.domain.entities.HallEntity;
import swapi.app.domain.entities.TicketEntity;
import swapi.app.repositories.BookingRepository;
import swapi.app.repositories.HallRepository;
import swapi.app.repositories.TicketRepository;
import swapi.app.services.BookingService;

import java.util.Optional;

@Component
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final TicketRepository ticketRepository;

    private final HallRepository hallRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, TicketRepository ticketRepository, HallRepository hallRepository) {
        this.bookingRepository = bookingRepository;
        this.ticketRepository = ticketRepository;
        this.hallRepository = hallRepository;
    }


    @Override
    public Iterable<BookingEntity> getBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<BookingEntity> createBooking(BookingEntity bookingEntity, String vip){
        if(vip != null) {
            bookingEntity.setIsVip(true);

            Optional<TicketEntity> ticket = ticketRepository.findByFilmId(bookingEntity.getFilmId());
            if(ticket.isEmpty())
                return null;
            Optional<HallEntity> hall = hallRepository.findByFilmId(bookingEntity.getHallId());
            if(hall.isEmpty())
                return null;
            if(hall.get().getSoldVipSeats() == hall.get().getVipSeats())
                return null;

            ticket.get().setDailySold(ticket.get().getDailySold() + 1);
            ticket.get().setWeeklySold(ticket.get().getWeeklySold() + 1);
            ticket.get().setMonthlySold(ticket.get().getMonthlySold() + 1);
            ticketRepository.save(ticket.get());

            hall.get().setSoldVipSeats(hall.get().getVipSeats() + 1);
            hallRepository.save(hall.get());

            return Optional.of(bookingRepository.save(bookingEntity));
        }else{
            bookingEntity.setIsVip(false);

            Optional<TicketEntity> ticket = ticketRepository.findByFilmId(bookingEntity.getFilmId());
            if(ticket.isEmpty())
                return null;
            Optional<HallEntity> hall = hallRepository.findByFilmId(bookingEntity.getHallId());
            if(hall.isEmpty())
                return null;
            if(hall.get().getSoldBaseSeats() == hall.get().getBaseSeats())
                return null;

            ticket.get().setDailySold(ticket.get().getDailySold() + 1);
            ticket.get().setWeeklySold(ticket.get().getWeeklySold() + 1);
            ticket.get().setMonthlySold(ticket.get().getMonthlySold() + 1);
            ticketRepository.save(ticket.get());

            hall.get().setSoldBaseSeats(hall.get().getSoldBaseSeats() + 1);
            hallRepository.save(hall.get());

            return Optional.of(bookingRepository.save(bookingEntity));
        }
    }
}
