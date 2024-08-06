package com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.adapter.search;

import com.doublevpartners.doublev_partners_tickets.domain.PageAsk;
import com.doublevpartners.doublev_partners_tickets.domain.Ticket;
import com.doublevpartners.doublev_partners_tickets.domain.TicketFilter;
import com.doublevpartners.doublev_partners_tickets.domain.port.search.TicketSearcherRepository;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.entity.TicketEntity;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.mapper.TicketPersistenceMapper;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.repository.TicketJpaRepository;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.specification.TicketSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Slf4j
@Repository
public class TicketSearcherPersistence implements TicketSearcherRepository {

    private final TicketJpaRepository ticketJpaRepository;
    private final TicketPersistenceMapper ticketPersistenceMapper;

    @Override
    public Supplier<Stream<Ticket>> searchAll(TicketFilter ticketFilter, PageAsk page) {
        Page<TicketEntity> response = ticketJpaRepository.findAll(
                new TicketSpecification(ticketFilter),
                PageRequest.of(
                        page.getPage(),
                        page.getSize(),
                        Sort.by(TicketSpecification.CREATION_DATE).descending()
                )
        );

        return response.map(ticketPersistenceMapper::toDomain);
    }

    @Override
    public Ticket search(UUID uuid) {
        return ticketPersistenceMapper.toDomain(ticketJpaRepository.findById(uuid).orElse(new TicketEntity()));
    }
}
