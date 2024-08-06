package com.doublevpartners.doublev_partners_tickets.infrastructure.rest.controller.update;

import com.doublevpartners.doublev_partners_tickets.application.search.TicketSearcher;
import com.doublevpartners.doublev_partners_tickets.application.update.TicketUpdater;
import com.doublevpartners.doublev_partners_tickets.domain.Ticket;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.mapper.TicketRestMapper;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.request.TicketRequest;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.response.TicketResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/tickets")
public class TicketUpdateController {

    private final TicketUpdater ticketUpdater;
    private final TicketSearcher ticketSearcher;

    public TicketUpdateController(TicketUpdater ticketUpdater, TicketSearcher ticketSearcher) {
        this.ticketUpdater = ticketUpdater;
        this.ticketSearcher = ticketSearcher;
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<TicketResponse> updateTicket(@PathVariable UUID id, @RequestBody TicketRequest ticketRequest) {
        Ticket existingTicket = ticketSearcher.searchById(id);
        if (existingTicket == null) {
            return ResponseEntity.notFound().build();
        }

        existingTicket = TicketRestMapper.toDomain(ticketRequest,existingTicket);

        Ticket savedTicket = ticketUpdater.update(existingTicket);
        return ResponseEntity.ok(TicketRestMapper.fromDomain(savedTicket));
    }

}
