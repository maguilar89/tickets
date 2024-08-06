package com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.adapter.update;

import com.doublevpartners.doublev_partners_tickets.domain.Ticket;
import com.doublevpartners.doublev_partners_tickets.domain.port.update.TicketUpdateRepository;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.mapper.TicketPersistenceMapper;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.repository.TicketJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Slf4j
@Repository
public class TicketUpdaterPersistence implements TicketUpdateRepository {

    private final TicketJpaRepository ticketJpaRepository;
    private final TicketPersistenceMapper ticketPersistenceMapper;

    @Override
    public Ticket update(Ticket ticket) {
        return ticketPersistenceMapper.toDomain(ticketJpaRepository.save(ticketPersistenceMapper.toEntity(ticket)));
    }
}
