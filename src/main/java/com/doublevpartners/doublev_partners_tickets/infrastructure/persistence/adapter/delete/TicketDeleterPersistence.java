package com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.adapter.delete;

import com.doublevpartners.doublev_partners_tickets.domain.port.deleter.TicketDeleterRepository;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.mapper.TicketPersistenceMapper;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.repository.TicketJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Repository
public class TicketDeleterPersistence implements TicketDeleterRepository {

    private final TicketJpaRepository ticketJpaRepository;

    @Override
    public void delete(UUID uuid) {
        ticketJpaRepository.deleteById(uuid);
    }

}
