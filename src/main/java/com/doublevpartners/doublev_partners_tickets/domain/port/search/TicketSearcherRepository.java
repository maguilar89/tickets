package com.doublevpartners.doublev_partners_tickets.domain.port.search;

import com.doublevpartners.doublev_partners_tickets.domain.PageAsk;
import com.doublevpartners.doublev_partners_tickets.domain.Ticket;
import com.doublevpartners.doublev_partners_tickets.domain.TicketFilter;

import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Stream;

public interface TicketSearcherRepository {

    Supplier<Stream<Ticket>> searchAll(TicketFilter ticketFilter, PageAsk page);

    Ticket search(UUID uuid);

}
