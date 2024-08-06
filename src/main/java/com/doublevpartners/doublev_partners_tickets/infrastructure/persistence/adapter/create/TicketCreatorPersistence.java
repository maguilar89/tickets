package com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.adapter.create;

import com.doublevpartners.doublev_partners_tickets.domain.Ticket;
import com.doublevpartners.doublev_partners_tickets.domain.port.create.TicketCreatorRepository;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.mapper.TicketPersistenceMapper;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.repository.TicketJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Slf4j
@Repository
public class TicketCreatorPersistence implements TicketCreatorRepository {

    private final TicketJpaRepository ticketJpaRepository;
    private final TicketPersistenceMapper ticketPersistenceMapper;

    @Override
    public Ticket save(Ticket ticket) {
        return ticketPersistenceMapper.toDomain(ticketJpaRepository.save(ticketPersistenceMapper.toEntity(ticket)));
    }

}
