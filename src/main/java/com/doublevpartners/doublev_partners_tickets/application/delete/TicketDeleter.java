package com.doublevpartners.doublev_partners_tickets.application.delete;

import com.doublevpartners.doublev_partners_tickets.domain.port.deleter.TicketDeleterRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TicketDeleter {

    private final TicketDeleterRepository ticketDeleterRepository;

    public TicketDeleter(TicketDeleterRepository ticketDeleterRepository) {
        this.ticketDeleterRepository = ticketDeleterRepository;
    }

    public void delete(UUID uuid){
        ticketDeleterRepository.delete(uuid);
    }
}
