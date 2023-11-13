package swapi.app.schedulers;


import org.springframework.scheduling.annotation.Scheduled;
import swapi.app.domain.entities.TicketEntity;
import swapi.app.services.TicketService;

import java.util.Iterator;

public class TicketSheduler {

    private final TicketService ticketService;

    public TicketSheduler(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    /*@Scheduled(cron = "0 20 4 * * ?")
    public void resetDailySold() {
        ticketService.resetDailySold();
    }*/
}
