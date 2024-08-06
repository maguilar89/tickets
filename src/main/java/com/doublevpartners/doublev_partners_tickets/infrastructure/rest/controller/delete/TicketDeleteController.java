package com.doublevpartners.doublev_partners_tickets.infrastructure.rest.controller.delete;

import com.doublevpartners.doublev_partners_tickets.application.delete.TicketDeleter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/tickets")
public class TicketDeleteController {

    private final TicketDeleter ticketDeleter;

    public TicketDeleteController(TicketDeleter ticketDeleter) {
        this.ticketDeleter = ticketDeleter;
    }

    @DeleteMapping("/{id}/delete")
    public void deleteTicket(@PathVariable UUID id) {
        ticketDeleter.delete(id);
    }


}
