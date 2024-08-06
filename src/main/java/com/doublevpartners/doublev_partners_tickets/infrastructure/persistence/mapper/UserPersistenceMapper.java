package com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.mapper;

import com.doublevpartners.doublev_partners_tickets.domain.User;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserPersistenceMapper {

    UserEntity toEntity(User user);

    User toDomain(UserEntity entity);

}
