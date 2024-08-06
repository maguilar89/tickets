package com.doublevpartners.doublev_partners_tickets.infrastructure.rest.response;

import com.doublevpartners.doublev_partners_tickets.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TicketResponse {

    User user;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @JsonProperty("modifiedDate")
    LocalDateTime modifiedDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @JsonProperty("CreationDate")
    LocalDateTime CreationDate;
    String status;
}
