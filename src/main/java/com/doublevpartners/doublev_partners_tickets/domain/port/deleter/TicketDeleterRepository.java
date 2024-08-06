package com.doublevpartners.doublev_partners_tickets.domain.port.deleter;

import java.util.UUID;

public interface TicketDeleterRepository {

    void delete(UUID uuid);

}
