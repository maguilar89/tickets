package com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.mapper;

import com.doublevpartners.doublev_partners_tickets.domain.Ticket;
import com.doublevpartners.doublev_partners_tickets.domain.enumeration.TicketStatusEnum;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.entity.TicketEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

/*@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        imports = TicketStatusEnum.class
)*/
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TicketPersistenceMapper {

    @Mapping(target = "status", source = "status.value")
    TicketEntity toEntity(Ticket ticket);

    @Mapping(target = "status", expression = "java(TicketStatusEnum.findByValue(entity.getStatus()))")
    Ticket toDomain(TicketEntity entity);

}
