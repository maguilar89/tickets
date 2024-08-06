package com.doublevpartners.doublev_partners_tickets.domain.port.update;

import com.doublevpartners.doublev_partners_tickets.domain.Ticket;

public interface TicketUpdateRepository {

    Ticket update(Ticket ticket);

}
