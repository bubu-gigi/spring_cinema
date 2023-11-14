package swapi.app.services;


import org.springframework.stereotype.Service;
import swapi.app.domain.entities.TicketEntity;

import java.util.Optional;

@Service
public interface TicketService {
    Iterable<TicketEntity> getTickets();
    Optional<TicketEntity> getTicket(Integer id);
    void deleteById(Integer id);
    TicketEntity createTicket(TicketEntity ticketEntity);
}
