package com.doublevpartners.doublev_partners_tickets.infrastructure.rest.controller.search;

import com.doublevpartners.doublev_partners_tickets.application.search.TicketSearcher;
import com.doublevpartners.doublev_partners_tickets.domain.PageAsk;
import com.doublevpartners.doublev_partners_tickets.domain.Ticket;
import com.doublevpartners.doublev_partners_tickets.domain.TicketFilter;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.mapper.TicketRestMapper;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.response.TicketResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping
public class TicketSearchController {

    private final TicketSearcher ticketSearcher;

    public TicketSearchController(TicketSearcher ticketSearcher) {
        this.ticketSearcher = ticketSearcher;
    }

    @GetMapping("/tickets")
    public Page<TicketResponse> search(@RequestParam (required = false) String initialDate,
                                       @RequestParam (required = false) String finalDate,
                                       @RequestParam(required = false) String status,
                                       @RequestParam(defaultValue = "0") Integer pageNumParam,
                                       @RequestParam(defaultValue = "10") Integer pageSizeParam) {
        return ((Page<Ticket>)
                ticketSearcher.searchAll(
                        TicketFilter
                                .builder()
                                .initialDate(initialDate!=null?LocalDate.parse(initialDate):null)
                                .finalDate(finalDate!=null?LocalDate.parse(finalDate):null)
                                .status(status)
                                .build(),
                        PageAsk.create(pageNumParam, pageSizeParam)
                )).map(TicketRestMapper::fromDomain);
    }

}
