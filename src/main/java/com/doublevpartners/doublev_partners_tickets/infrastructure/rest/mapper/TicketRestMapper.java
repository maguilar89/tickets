package com.doublevpartners.doublev_partners_tickets.infrastructure.rest.mapper;

import com.doublevpartners.doublev_partners_tickets.domain.Ticket;
import com.doublevpartners.doublev_partners_tickets.domain.enumeration.TicketStatusEnum;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.request.TicketRequest;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.response.TicketResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class TicketRestMapper {


    public TicketRestMapper() {
    }

    TicketResponse toResponse(Ticket ticket){

        return null;
    }

    public static TicketResponse fromDomain(Ticket ticket){

        if (ticket == null) {
            return null;
        }

        TicketResponse response = new TicketResponse();

        if (Objects.nonNull(ticket.getStatus())) {
            response.setStatus(ticket.getStatus().getValue());
        }

        response.setCreationDate(ticket.getCreationDate());
        response.setModifiedDate(ticket.getModifiedDate());
        return response;
    }

    public static Ticket toDomain(TicketRequest ticketRequest){

        if (ticketRequest == null) {
            return null;
        }

        Ticket ticket = new Ticket();

        if (Objects.nonNull(ticketRequest.getStatus())) {
            ticket.setStatus(TicketStatusEnum.findByValue(ticketRequest.getStatus()));
        }

        ticket.setCreationDate(ticketRequest.getCreationDate());
        ticket.setModifiedDate(ticketRequest.getModifiedDate());
        return ticket;
    }

    public static Ticket toDomain(TicketRequest ticketRequest, Ticket oldTicket){

        if (ticketRequest == null) {
            return null;
        }

        if (Objects.nonNull(ticketRequest.getStatus())) {
            oldTicket.setStatus(TicketStatusEnum.findByValue(ticketRequest.getStatus()));
        }

        oldTicket.setId(oldTicket.getId());
        oldTicket.setCreationDate(oldTicket.getCreationDate());
        oldTicket.setModifiedDate(LocalDateTime.now());
        return oldTicket;
    }

}
