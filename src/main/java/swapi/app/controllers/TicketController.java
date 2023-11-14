package swapi.app.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swapi.app.domain.dto.TicketDto;
import swapi.app.domain.entities.TicketEntity;
import swapi.app.mappers.Mapper;
import swapi.app.repositories.TicketRepository;
import swapi.app.services.TicketService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class TicketController {

    private final TicketService ticketService;
    private final Mapper<TicketEntity, TicketDto> ticketMapper;

    public TicketController(TicketService ticketService, Mapper<TicketEntity, TicketDto> ticketMapper) {
        this.ticketService = ticketService;
        this.ticketMapper = ticketMapper;
    }

    @GetMapping(path = "/api/tickets")
    public List<TicketDto> show() {
        Iterable<TicketEntity> tickets = ticketService.getTickets();
        Iterator<TicketEntity> it = tickets.iterator();
        List<TicketDto> list = new ArrayList<>();
        while(it.hasNext())
            list.add(ticketMapper.mapTo(it.next()));
        return list;
    }

    @GetMapping(path = "/api/tickets/{id}")
    public ResponseEntity<TicketDto> getTicket(@PathVariable("id") Integer id) {
        Optional<TicketEntity> ticket = ticketService.getTicket(id);
        if(ticket.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(ticketMapper.mapTo(ticket.get()), HttpStatus.OK);
    }

    @PostMapping(path = "/api/tickets")
    public ResponseEntity<TicketDto> postTicket(@RequestBody TicketDto ticketDto) {
        TicketEntity ticketEn = ticketMapper.mapFrom(ticketDto);
        ticketService.createTicket(ticketEn);
        return new ResponseEntity<>(ticketMapper.mapTo(ticketEn), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/api/tickets/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable(name = "id") Integer id) {
        Optional<TicketEntity> ticket = ticketService.getTicket(id);
        if(ticket.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        ticketService.deleteById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
}
