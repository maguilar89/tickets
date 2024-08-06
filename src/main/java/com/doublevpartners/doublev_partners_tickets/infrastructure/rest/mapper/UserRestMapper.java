package com.doublevpartners.doublev_partners_tickets.infrastructure.rest.mapper;

import com.doublevpartners.doublev_partners_tickets.domain.User;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserRestMapper {

    UserResponse toResponse(User user);

    User toDomain(UserResponse userResponse);

}
