package com.doublevpartners.doublev_partners_tickets.domain;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Value
public class TicketFilter implements Serializable {

    LocalDate initialDate;
    LocalDate finalDate;
    String status;

}
