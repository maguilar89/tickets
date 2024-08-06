package com.doublevpartners.doublev_partners_tickets.infrastructure.rest.controller.create;

import com.doublevpartners.doublev_partners_tickets.application.create.TicketCreator;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.mapper.TicketRestMapper;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.request.TicketRequest;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.response.TicketResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/ticket")
public class TicketCreatorController {

    private final TicketCreator ticketCreator;

    public TicketCreatorController(TicketCreator ticketCreator) {
        this.ticketCreator = ticketCreator;
    }

    @PostMapping
    public TicketResponse createTicket(@RequestBody TicketRequest ticketRequest){
        return  TicketRestMapper.fromDomain(ticketCreator.create(TicketRestMapper.toDomain(ticketRequest)));
    }

}
