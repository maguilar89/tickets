package com.doublevpartners.doublev_partners_tickets.domain;

import com.doublevpartners.doublev_partners_tickets.domain.enumeration.TicketStatusEnum;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Ticket {

    UUID id;
    User user;
    LocalDateTime modifiedDate;
    LocalDateTime CreationDate;
    TicketStatusEnum status;
}
