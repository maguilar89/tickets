package com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket")
@Entity
public class TicketEntity {

    @Id
    @Basic(optional = false)
    @Column(unique = true)
    private UUID id;

    @Column(name = "fecha_creacion")
    private LocalDateTime creationDate;

    @Column(name = "fecha_modificacion")
    private LocalDateTime modifiedDate;

    @Column(name = "status")
    private String status;

}
