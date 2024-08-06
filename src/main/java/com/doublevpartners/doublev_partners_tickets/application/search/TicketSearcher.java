package com.doublevpartners.doublev_partners_tickets.application.search;

import com.doublevpartners.doublev_partners_tickets.domain.PageAsk;
import com.doublevpartners.doublev_partners_tickets.domain.Ticket;
import com.doublevpartners.doublev_partners_tickets.domain.TicketFilter;
import com.doublevpartners.doublev_partners_tickets.domain.port.search.TicketSearcherRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Service
public class TicketSearcher {

    private final TicketSearcherRepository ticketSearcherRepository;

    public TicketSearcher(TicketSearcherRepository ticketSearcherRepository) {
        this.ticketSearcherRepository = ticketSearcherRepository;
    }

    public Supplier<Stream<Ticket>> searchAll(TicketFilter ticketFilter, PageAsk page) {
        return ticketSearcherRepository.searchAll(ticketFilter, page);
    }

    public Ticket searchById(UUID uuid) {
        return ticketSearcherRepository.search(uuid);
    }

}
