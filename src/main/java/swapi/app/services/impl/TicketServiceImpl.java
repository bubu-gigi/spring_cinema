package swapi.app.services.impl;


import org.springframework.stereotype.Component;
import swapi.app.domain.entities.TicketEntity;
import swapi.app.repositories.TicketRepository;
import swapi.app.services.TicketService;

import java.util.Optional;

@Component
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Iterable<TicketEntity> getTickets() {
        return ticketRepository.findAll();
    }

    public Optional<TicketEntity> getTicket(Integer id) {
        return ticketRepository.findById(id);
    }

    public Optional<TicketEntity> getTicketByFilmId(Integer id) { return ticketRepository.findByFilmId(id); }

    public TicketEntity createTicket(TicketEntity ticketEntity) {
        return ticketRepository.save(ticketEntity);
    }
}
