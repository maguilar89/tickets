package com.doublevpartners.doublev_partners_tickets.domain.port.create;

import com.doublevpartners.doublev_partners_tickets.domain.Ticket;

public interface TicketCreatorRepository {

    Ticket save(Ticket ticket);

}
