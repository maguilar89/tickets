package com.doublevpartners.doublev_partners_tickets.application.create;

import com.doublevpartners.doublev_partners_tickets.domain.Ticket;
import com.doublevpartners.doublev_partners_tickets.domain.port.create.TicketCreatorRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TicketCreator {

    private final TicketCreatorRepository ticketCreatorRepository;

    public TicketCreator(TicketCreatorRepository ticketCreatorRepository) {
        this.ticketCreatorRepository = ticketCreatorRepository;
    }


    public Ticket create(Ticket ticket) {
        ticket.setId(UUID.randomUUID());
        return ticketCreatorRepository.save(ticket);
    }

}
