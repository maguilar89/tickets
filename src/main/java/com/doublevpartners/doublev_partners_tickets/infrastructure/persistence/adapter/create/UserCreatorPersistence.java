package com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.adapter.create;

import com.doublevpartners.doublev_partners_tickets.domain.User;
import com.doublevpartners.doublev_partners_tickets.domain.port.create.UserCreatorRepository;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.mapper.UserPersistenceMapper;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Slf4j
@Repository
public class UserCreatorPersistence implements UserCreatorRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserPersistenceMapper userPersistenceMapper;

    @Override
    public User save(User user) {
        return userPersistenceMapper.toDomain(userJpaRepository.save(userPersistenceMapper.toEntity(user)));
    }
}
