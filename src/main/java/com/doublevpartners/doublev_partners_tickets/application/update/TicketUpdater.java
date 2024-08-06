package com.doublevpartners.doublev_partners_tickets.application.update;

import com.doublevpartners.doublev_partners_tickets.domain.Ticket;
import com.doublevpartners.doublev_partners_tickets.domain.port.update.TicketUpdateRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketUpdater {

    private final TicketUpdateRepository ticketUpdateRepository;

    public TicketUpdater(TicketUpdateRepository ticketUpdateRepository) {
        this.ticketUpdateRepository = ticketUpdateRepository;
    }

    public Ticket update(Ticket ticket) {
        return ticketUpdateRepository.update(ticket);
    }

}
