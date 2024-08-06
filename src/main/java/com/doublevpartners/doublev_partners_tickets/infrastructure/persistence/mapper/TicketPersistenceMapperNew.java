package com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.mapper;

import com.doublevpartners.doublev_partners_tickets.domain.Ticket;
import com.doublevpartners.doublev_partners_tickets.domain.enumeration.TicketStatusEnum;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.entity.TicketEntity;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.request.TicketRequest;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.response.TicketResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class TicketPersistenceMapperNew {

    public static TicketEntity toEntity(Ticket ticket){

        if (ticket == null) {
            return null;
        }

        TicketEntity entity = new TicketEntity();

        if (Objects.nonNull(ticket.getStatus())) {
            entity.setStatus(ticket.getStatus().getValue());
        }

        entity.setCreationDate(ticket.getCreationDate());
        entity.setModifiedDate(ticket.getModifiedDate());
        return entity;
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


}
