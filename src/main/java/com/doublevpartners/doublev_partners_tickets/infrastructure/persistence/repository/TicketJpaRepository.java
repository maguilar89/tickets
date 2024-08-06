package com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.repository;

import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketJpaRepository extends JpaRepository<TicketEntity, UUID>,
            JpaSpecificationExecutor<TicketEntity> {

}
