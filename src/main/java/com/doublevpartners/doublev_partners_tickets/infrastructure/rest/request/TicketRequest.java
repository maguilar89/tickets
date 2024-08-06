package com.doublevpartners.doublev_partners_tickets.infrastructure.rest.request;

import com.doublevpartners.doublev_partners_tickets.domain.User;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Value
@Jacksonized
public class TicketRequest {

    User user;
    UUID uuid;
    LocalDateTime modifiedDate;
    LocalDateTime CreationDate;
    String status;

}
